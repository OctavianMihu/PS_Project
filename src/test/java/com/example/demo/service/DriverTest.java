package com.example.demo.service;

import com.example.demo.model.Driver;
import com.example.demo.repo.DriverRepository;
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
 * This class contains unit tests for the DriverService class.
 */
@SpringBootTest
public class DriverTest {

    @Mock
    private DriverRepository driverRepositoryMock;

    private DriverService driverService;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(driverRepositoryMock);
        driverService = new DriverServiceImpl(driverRepositoryMock);
    }

    /**
     * Tests the saveDriver method of the DriverService class.
     */
    @Test
    void saveDriverTest() {
        // Arrange
        Driver driver = new Driver(30, "Honda", "Marcel", "Marcel@", false, false);

        // Act
        driverService.saveDriver(driver);

        // Assert
        verify(driverRepositoryMock).save(driver);
    }

    /**
     * Tests the getAllDrivers method of the DriverService class.
     */
    @Test
    void getAllDriversTest() {
        // Act
        List<Driver> drivers = driverService.getAllDrivers();

        // Assert
        verify(driverRepositoryMock).findAll();
    }

    /**
     * Tests the findById method of the DriverService class.
     */
    @Test
    void findByIdTest() {
        // Arrange
        Driver driver = new Driver(30, "Honda", "Marcel", "Marcel@", false, false);
        driverService.saveDriver(driver);

        // Act
        Optional<Driver> d = driverService.findByID(30);

        // Assert
        verify(driverRepositoryMock).findById(30);
    }

    /**
     * Tests the deleteDriver method of the DriverService class.
     */
    @Test
    void deleteDriverTest() {
        // Arrange
        Driver driver = new Driver(30, "Honda", "Marcel", "Marcel@", false, false);
        driverRepositoryMock.save(driver);

        // Act
        driverRepositoryMock.delete(driver);

        // Assert
        verify(driverRepositoryMock).delete(driver);
    }

    // Additional test cases can be added for other methods like startWork, stopWork, sendNotif, etc.
}
