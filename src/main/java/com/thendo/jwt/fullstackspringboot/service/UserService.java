package com.thendo.jwt.fullstackspringboot.service;

import com.thendo.jwt.fullstackspringboot.models.dto.CredentialsDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.SignUpDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.UserDTO;

public interface UserService {
    UserDTO register(SignUpDTO signUpDTO);

    UserDTO login(CredentialsDTO credentialsDTO);
}
