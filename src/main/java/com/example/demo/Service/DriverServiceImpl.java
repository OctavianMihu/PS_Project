package com.example.demo.Service;

import com.example.demo.Repo.DriverRepository;
import com.example.demo.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of DriverService interface providing CRUD operations for Driver entities.
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    private final NotificationService notificationService;

    public DriverServiceImpl() {
        this.notificationService = new NotificationService();
    }

    /**
     * Saves a driver entity.
     *
     * @param driver The driver object to be saved.
     * @return The saved driver object.
     */
    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    /**
     * Retrieves a list of all drivers.
     *
     * @return A list containing all drivers.
     */
    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    /**
     * Finds a driver by their ID.
     *
     * @param id The ID of the driver to find.
     * @return An Optional containing the driver if found, otherwise empty.
     */
    @Override
    public Optional<Driver> findByID(int id) {
        return driverRepository.findById(id);
    }

    /**
     * Deletes a driver by their ID.
     *
     * @param id The ID of the driver to delete.
     * @return True if the driver was successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteDriver(int id) {
        Optional<Driver> d = findByID(id);
        if (d.isPresent()) {
            Driver driver = d.get();
            driverRepository.delete(driver);
            return true;
        }
        return false;
    }

    /**
     * Starts the work for a driver identified by ID.
     *
     * @param id The ID of the driver to start work.
     */
    @Override
    public void startWork(int id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            driver.setWorking(true);
            driverRepository.save(driver);
            notificationService.working(new DriverListener(driver.getId()));
        }
    }

    /**
     * Stops the work for a driver identified by ID.
     *
     * @param id The ID of the driver to stop work.
     */
    @Override
    public void stopWork(int id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            driver.setWorking(false);
            driverRepository.save(driver);
            notificationService.stoppedWorking(new DriverListener(driver.getId()));
        }
    }

    /**
     * Sends notification to drivers.
     */
    @Override
    public void sendNotif() {
        notificationService.sendNotification();
    }

    /**
     * Retrieves the notification service associated with this driver service.
     *
     * @return The notification service.
     */
    public NotificationService getNotificationService() {
        return notificationService;
    }

    /**
     * Notifies drivers of available work.
     * Not yet implemented properly
     */
    public void workAvailable() {
        notificationService.sendNotification();
    }
}
