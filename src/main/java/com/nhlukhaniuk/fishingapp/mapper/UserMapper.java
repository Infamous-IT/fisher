package com.nhlukhaniuk.fishingapp.mapper;

import com.nhlukhaniuk.fishingapp.dto.UserDTO;
import com.nhlukhaniuk.fishingapp.model.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
    List<UserDTO> userToUserDTOList(List<User> users);
    User userDTOToUser(UserDTO userDTO);
}
