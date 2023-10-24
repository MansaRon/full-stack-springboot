package com.thendo.jwt.fullstackspringboot.mappers;

import com.thendo.jwt.fullstackspringboot.models.dto.SignUpDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.UserDTO;
import com.thendo.jwt.fullstackspringboot.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);

    // password ignored because it has a different format.
    // There is a car array in the signUpDTO and a string in the user class
    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDTO signUpDTO);

}
