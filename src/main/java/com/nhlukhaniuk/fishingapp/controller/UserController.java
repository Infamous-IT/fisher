package com.nhlukhaniuk.fishingapp.controller;

import com.nhlukhaniuk.fishingapp.dto.UserDTO;
import com.nhlukhaniuk.fishingapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/secured/user")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public String userAccess(Principal principal) {
//        if (principal == null) {
//            return null;
//        }
//        return principal.getName();
//    }

    @PostMapping(value = "/create")
    public UserDTO create(UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @GetMapping
    public List<UserDTO> get() {
        return userService.get();
    }

    @GetMapping(value = "/:id")
    public UserDTO get(UUID id) {
        return userService.getById(id);
    }

    @PostMapping(value = "/update")
    public UserDTO update(UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping(value = "/:id")
    public void delete(UUID id) {
        userService.delete(id);
    }
}
