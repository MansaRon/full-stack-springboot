package com.thendo.jwt.fullstackspringboot.service;

import com.thendo.jwt.fullstackspringboot.mappers.UserMapper;
import com.thendo.jwt.fullstackspringboot.mappers.UserMapperImpl;
import com.thendo.jwt.fullstackspringboot.repository.UserRepository;
import com.thendo.jwt.fullstackspringboot.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;

// Old versions used @RunWith
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    // service which receives the mocks
    private UserServiceImpl userServiceImpl;

    @Mock
    // services which are empty, dummy and have no behaviour
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Spy
    // services that are injected. CAn verify calls that they receive
    private UserMapper userMapper = new UserMapperImpl();

    @Test
    void loginTest() {
        // given (initialise values, input parameters and the state of the system)
//        String login = "thendo";
//        String password = "123456";

//        CredentialsDTO credentialsDTO = new CredentialsDTO(login, password.toCharArray());
//
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(passwordEncoder.encode(password));
//
//        UserDTO expectedUserDTO = new UserDTO();
//        expectedUserDTO.setLogin(login);
//
//        when(userRepository.findByLogin(login)).thenReturn(Optional.of(user));
//        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);
//        when(userMapper.toUserDTO(user)).thenReturn(expectedUserDTO);

        // when (call methods to be tested)
//        UserDTO result = userService.login(credentialsDTO);

        // then (check results of the test)
//        assertNotNull(result);
//        assertEquals(login, result.getLogin());
//        verify(userRepository).findByLogin(login);
//        verify(passwordEncoder).matches(password, user.getPassword());
//        verify(userMapper).toUserDTO(user);
    }

    @Test()
    void userNotFoundTest() {
        // given (initialise values, input parameters and the state of the system)
//        String login = "thendo";
//        String password = "123456";
//        CredentialsDTO credentialsDTO = new CredentialsDTO(login, password.toCharArray());
//        when(userRepository.findByLogin(login)).thenReturn(Optional.empty());

        // when (call methods to be tested)
        //        userService.login(credentialsDTO);

        // then (check results of the test)
//        assertThrows(AppException.class, () -> userService.login(credentialsDTO));
    }

    @Test
    void invalidPasswordTest() {
        // given (initialise values, input parameters and the state of the system)
//        String login = "thendo";
//        String password = "123456";
//        CredentialsDTO credentialsDTO = new CredentialsDTO(login, password.toCharArray());

//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(passwordEncoder.encode(password));

        // when (call methods to be tested)
//        when(userRepository.findByLogin(login)).thenReturn(Optional.empty());
//        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(false);

        // then (check results of the test)
        //assertThrows(AppException.class, () -> userService.login(credentialsDTO));
    }

    @Test
    void registerTest() {
        // given (initialise values, input parameters and the state of the system)
//        String name = "Thendo";
//        String surname = "Ramashia";
//        String login = "thendo";
//        String password = "123456";

//        SignUpDTO signUpDTO = new SignUpDTO(name, surname, login, password.toCharArray());

//        User createUser = new User();
//        createUser.setFirstName(name);
//        createUser.setLastName(surname);
//        createUser.setLogin(login);
//        createUser.setPassword(password);

//        User saveUser = new User();
//        saveUser.setLogin(login);

//        UserDTO userDTO = new UserDTO();
//        userDTO.setLogin(login);

//        when(userRepository.findByLogin(login)).thenReturn(Optional.empty());
//        when(userMapper.signUpToUser(signUpDTO)).thenReturn(createUser);
//        when(passwordEncoder.encode(password)).thenReturn(createUser.getPassword());
//        when(userRepository.save(createUser)).thenReturn(saveUser);
//        when(userMapper.toUserDTO(saveUser)).thenReturn(userDTO);

        // when (call methods to be tested)
//        UserDTO result = userService.register(signUpDTO);

        // then (check results of the test)
//        assertNotNull(result);
//        assertEquals(login, result.getLogin());
//        verify(userRepository).findByLogin(login);
//        verify(userMapper).signUpToUser(signUpDTO);
//        verify(passwordEncoder).encode(password);
//        verify(userRepository).save(createUser);
//        verify(userMapper).toUserDTO(saveUser);
    }
}
