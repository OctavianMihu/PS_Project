package com.example.demo.Service;

import com.example.demo.model.Driver;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Driver entities.
 */
public interface DriverService {
    public Driver saveDriver(Driver driver);

    List<Driver> getAllDrivers();

    public Optional<Driver> findByID(int id);
    public boolean deleteDriver(int id);

}
