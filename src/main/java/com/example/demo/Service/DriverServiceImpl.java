package com.example.demo.Service;

import com.example.demo.Repo.DriverRepository;

import com.example.demo.model.Driver;
import com.example.demo.model.User;
import com.example.demo.observer.NotificationService;
import com.example.demo.observer.Observer;
import com.example.demo.observer.RideAlertListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Implementation of DriverService interface providing CRUD operations for Driver entities.
 */
@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepository driverRepository;
    private final Observer obs = new Observer(new NotificationService());

    public DriverServiceImpl() {
        this.drivers = new ArrayList<>();
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
        if(d.isPresent()){
            Driver driver = d.get();
            driverRepository.delete(driver);
            return true;
            //String displayName = pageDetail.map(PageDetail::getName).orElse(uri);
        }
        return false;
    }

    @Override
    public void startWork(int id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()){
            Driver driver = optionalDriver.get();
            driver.setWorking(true);
            driverRepository.save(driver);
            RideAlertListener.addDriver(driver);
        }
    }
    public void stopWork(int id){
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()){
            Driver driver = optionalDriver.get();
            driver.setWorking(false);
            driverRepository.save(driver);
            obs.ad
        }
    }

    public void notifyDrivers() {
       obs.notify();
    }


}
