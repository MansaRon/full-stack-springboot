package com.thendo.jwt.fullstackspringboot.service.implementation;

import com.thendo.jwt.fullstackspringboot.config.UserAuthProvider;
import com.thendo.jwt.fullstackspringboot.models.dto.CredentialsDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.SignUpDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.UserDTO;
import com.thendo.jwt.fullstackspringboot.entities.User;
import com.thendo.jwt.fullstackspringboot.exceptions.AppException;
import com.thendo.jwt.fullstackspringboot.mappers.UserMapper;
import com.thendo.jwt.fullstackspringboot.repository.UserRepository;
import com.thendo.jwt.fullstackspringboot.service.UserService;
import com.thendo.jwt.fullstackspringboot.util.ExecutionTimeLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserAuthProvider userAuthProvider;

    @ExecutionTimeLogger
    public UserDTO register(SignUpDTO signUpDTO) {
        Optional<User> user = userRepository.findByLogin(signUpDTO.login());

        if (user.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        // Create User
        User createUser = userMapper.signUpToUser(signUpDTO);
        createUser.addRoles("USER");
        createUser.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDTO.password())));
        User saveUser = userRepository.save(createUser);

        return userMapper.toUserDTO(saveUser);
    }

    @ExecutionTimeLogger
    public UserDTO login(CredentialsDTO credentialsDTO) {
        User user = userRepository.findByLogin(credentialsDTO.login())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.password()), user.getPassword())) {
            // When correct, map the User from the database to the userDTO
            return userMapper.toUserDTO(user);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

}
