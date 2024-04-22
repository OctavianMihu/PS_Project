package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * This class contains unit tests for the UserService class.
 */
@SpringBootTest
class UserTest {

    @Mock
    private UserRepository userRepositoryMock;

    private UserService userService;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepositoryMock);
    }

    /**
     * Tests the saveUser method of the UserService class.
     */
    @Test
    public void saveUserTest() {
        // Arrange
        User user = new User(20, "Migi", "Miki@yahoo.com", false);

        // Act
        userService.saveUser(user);

        // Assert
        verify(userRepositoryMock).save(user);
    }

    /**
     * Tests the getAllUsers method of the UserService class.
     */
    @Test
    public void getAllUsersTest() {
        // Act
        List<User> users = userService.getAllUsers();

        // Assert
        verify(userRepositoryMock).findAll();
    }

    /**
     * Tests the findById method of the UserService class.
     */
    @Test
    public void findByIdTest() {
        // Arrange
        User user = new User(20, "Migi", "Miki@yahoo.com", false);
        userService.saveUser(user);

        // Act
        Optional<User> u = userService.findByID(30);

        // Assert
        verify(userRepositoryMock).findById(30);
    }

    /**
     * Tests the deleteUser method of the UserService class.
     */
    @Test
    public void deleteUserTest(){
        // Arrange
        User user = new User(30, "Lka", "Lka@yahoo.com", false);
        userRepositoryMock.save(user);

        // Act
        userRepositoryMock.delete(user);

        // Assert
        verify(userRepositoryMock).delete(user);
    }

    /**
     * Tests the wantsRide method of the UserService class.
     */
    @Test
    public void wantsRideTest(){
        // Arrange
        User user = new User(30, "Ok", "Ok@yas", false);
        userService.saveUser(user);

        // Act & Assert
        assertEquals(userService.wantsRide(30), true);
    }
}
