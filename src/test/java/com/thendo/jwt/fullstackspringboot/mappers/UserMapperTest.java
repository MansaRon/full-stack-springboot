package com.thendo.jwt.fullstackspringboot.mappers;

import com.thendo.jwt.fullstackspringboot.models.dto.UserDTO;
import com.thendo.jwt.fullstackspringboot.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserMapperTest {

    private static UserMapper userMapper;

    @BeforeAll // This will be executed before all the tests, it will run 1st before any tests
    public static void setUp() {
        userMapper = new UserMapperImpl();
    }

    @Test
    void testUserMapper() {
        // given (initialise values, input parameters and the state of the system)
        User user = User.builder()
                .id(1)
                .firstName("Thendo")
                .lastName("Ramashia")
                .login("thendo")
                .password("123456")
                .build();

        // when (call methods to be tested)
        UserDTO userDTO = userMapper.toUserDTO(user);

        // then (check results of the test)
        assertAll(
                () -> {
                    assertEquals(user.getFirstName(), userDTO.getFirstName());
                    assertEquals(user.getLastName(), userDTO.getLastName());
                }
        );
    }

}