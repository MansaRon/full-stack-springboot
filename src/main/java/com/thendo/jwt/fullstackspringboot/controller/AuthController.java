package com.thendo.jwt.fullstackspringboot.controller;

import com.thendo.jwt.fullstackspringboot.config.UserAuthProvider;
import com.thendo.jwt.fullstackspringboot.controller.api.AbstractAuthController;
import com.thendo.jwt.fullstackspringboot.models.api.resource.UserApiSignUpResource;
import com.thendo.jwt.fullstackspringboot.models.dto.CredentialsDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.SignUpDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.UserDTO;
import com.thendo.jwt.fullstackspringboot.service.implementation.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AbstractAuthController {

    private final UserServiceImpl userServiceImpl;
    private final UserAuthProvider userAuthProvider;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

//    @PostMapping("/register")
//    public ResponseEntity<ApiResponse> register(@RequestBody SignUpDTO signUpDTO) {
//        logger.info("public ResponseEntity<UserDTO> register(@RequestBody SignUpDTO signUpDTO)");
//        UserDTO user = userService.register(signUpDTO);
//        return builder.buildResponse(HttpStatus.CREATED.value(), "User registered", user);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse> login(@RequestBody CredentialsDTO credentialsDTO) {
//        logger.info("public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentialsDTO)");
//        UserDTO userDTO = userService.login(credentialsDTO);
//        userDTO.setToken(userAuthProvider.createToken(userDTO));
//        return builder.buildResponse(HttpStatus.OK.value(), "User logged in", userDTO);
//    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<UserApiSignUpResource> register(@RequestBody @Valid SignUpDTO signUpDTO) {
        logger.info("public ResponseEntity<UserApiSignUpResource> register(@RequestBody SignUpDTO signUpDTO)");
        UserDTO user = userServiceImpl.register(signUpDTO);
        return ResponseEntity.ok(
                UserApiSignUpResource.builder()
                        .timestamp(Instant.now())
                        .data(user)
                        .message("User registered")
                        .status(String.valueOf(HttpStatus.OK))
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<UserApiSignUpResource> login(@RequestBody @Valid CredentialsDTO credentialsDTO) {
        logger.info("public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentialsDTO)");
        UserDTO userDTO = userServiceImpl.login(credentialsDTO);
        userDTO.setToken(userAuthProvider.createToken(userDTO));
        return ResponseEntity.ok(
                UserApiSignUpResource.builder()
                        .timestamp(Instant.now())
                        .data(userDTO)
                        .message("User logged in")
                        .status(String.valueOf(HttpStatus.OK))
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    // TODO
    // Implement confirm registration from email
}
