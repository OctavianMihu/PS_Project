package com.example.demo.Service;

import com.example.demo.Repo.DriverRepository;

import com.example.demo.model.Driver;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Implementation of DriverService interface providing CRUD operations for Driver entities.
 */
@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepository driverRepository;
    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
    @Override
    public Optional<Driver> findByID(int id) {
        return driverRepository.findById(id);
    }

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
}
