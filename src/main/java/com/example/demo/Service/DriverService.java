package com.example.demo.Service;

import com.example.demo.model.Driver;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Driver entities.
 */
public interface DriverService {
    Driver saveDriver(Driver driver);

    List<Driver> getAllDrivers();

    Optional<Driver> findByID(int id);

    boolean deleteDriver(int id);

    Driver startWork(int id);
    Driver stopWork(int id);


}
