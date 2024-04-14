package com.example.demo.Service;

import com.example.demo.model.Driver;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Driver entities.
 */
public interface DriverService {

    /**
     * Saves a driver entity.
     *
     * @param driver The driver object to be saved.
     * @return The saved driver object.
     */
    Driver saveDriver(Driver driver);

    /**
     * Retrieves a list of all drivers.
     *
     * @return A list containing all drivers.
     */
    List<Driver> getAllDrivers();

    /**
     * Finds a driver by their ID.
     *
     * @param id The ID of the driver to find.
     * @return An Optional containing the driver if found, otherwise empty.
     */
    Optional<Driver> findByID(int id);

    /**
     * Deletes a driver by their ID.
     *
     * @param id The ID of the driver to delete.
     * @return True if the driver was successfully deleted, false otherwise.
     */
    boolean deleteDriver(int id);

    /**
     * Starts the work for a driver identified by ID.
     *
     * @param id The ID of the driver to start work.
     */
    void startWork(int id);

    /**
     * Stops the work for a driver identified by ID.
     *
     * @param id The ID of the driver to stop work.
     */
    void stopWork(int id);

    /**
     * Sends notification to drivers.
     */
    void sendNotif();
}
