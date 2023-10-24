package com.thendo.jwt.fullstackspringboot.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.thendo.jwt.fullstackspringboot.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
// Used to list TestExecutionListner classes
@TestExecutionListeners({
        // Integrates Spring dependency injection framework with JUnit tests.
        DependencyInjectionTestExecutionListener.class,
        // Useful when a test modifies the state of the application context
        // and subsequent tests need to start with a clean and fresh context
        DirtiesContextTestExecutionListener.class,
        // This listener manages transactions for tests annotated with @Transactional
        TransactionalTestExecutionListener.class,
        // This listener integrates database testing with JUnit tests.
        // Provides functionality for loading and managing test data from external sources,
        // such as XML or YAML datasets, into the database before test execution.
        DbUnitTestExecutionListener.class
})
public class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    void testFindByLogin() {
        // given
//        String login = "thendo";

        // when
//        Optional<User> user = userRepository.findByLogin(login);

        // then
//        assertAll(() -> {
//            assertTrue(user.isPresent());
//            assertEquals(login, user.get().getLogin());
//            assertEquals(10L, user.get().getId());
//        });
    }
}
