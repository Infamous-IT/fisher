package com.nhlukhaniuk.fishingapp.service;

import com.nhlukhaniuk.fishingapp.auth.UserDetailsImpl;
import com.nhlukhaniuk.fishingapp.dto.UserDTO;
import com.nhlukhaniuk.fishingapp.mapper.UserMapper;
import com.nhlukhaniuk.fishingapp.model.User;
import com.nhlukhaniuk.fishingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User '%s' was not found", username)
                ));
        return UserDetailsImpl.build(user);
    }

    @Override
    public List<UserDTO> get() {
        return userMapper.userToUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User createdUser = userRepository.save(user);
        return userMapper.userToUserDTO(createdUser);
    }

    @Override
    public UserDTO getById(UUID uuid) {
        User user = userRepository.getReferenceById(uuid);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + uuid + " was not found!");
        }

        return userMapper.userToUserDTO(user);
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }
}
