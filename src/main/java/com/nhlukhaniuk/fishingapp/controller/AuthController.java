package com.nhlukhaniuk.fishingapp.controller;

import com.nhlukhaniuk.fishingapp.auth.JwtCore;
import com.nhlukhaniuk.fishingapp.dto.UserDTO;
import com.nhlukhaniuk.fishingapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private PasswordEncoder passwordEncoder;
    private UserServiceImpl userService;
    private JwtCore jwtCore;

    private AuthenticationManager authenticationManager;


    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, UserServiceImpl userService, JwtCore jwtCore, @Qualifier("authenticationManager") AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtCore = jwtCore;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    ResponseEntity<?> signUp(@RequestBody UserDTO userDTO) {
        if (userService.existsUserByUsername(userDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different name!");
        }

        String hashed = passwordEncoder.encode(userDTO.getPassword());

        UserDTO userDTOs = new UserDTO();
        userDTOs.setUsername(userDTO.getUsername());
        userDTOs.setPassword(hashed);
        userDTOs.setRole(userDTO.getRole());

        userService.create(userDTOs);
        return ResponseEntity.ok("Creation success!");
    }

    @PostMapping("/sign_in")
    ResponseEntity<?> signIn(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(), userDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }
}
