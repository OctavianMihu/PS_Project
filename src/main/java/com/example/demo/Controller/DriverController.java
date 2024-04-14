package com.example.demo.Controller;

import com.example.demo.Service.DriverService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Driver;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing Driver entities.
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;
    /**
     * Adds a new driver.
     *
     * @param driver The driver object to be added.
     * @return A message indicating that a new driver has been added.
     */
    @PostMapping("/adddriver")
    public String addUser(@RequestBody Driver driver){
        driverService.saveDriver(driver);
        return "New driver added";
    }

    /**
     * Retrieves all drivers.
     *
     * @return A list of all drivers.
     */
    @GetMapping("/getalldriver")
    public List<Driver> getAllUsers(){
        return driverService.getAllDrivers();
    }

    /**
     * Deletes a driver by ID.
     *
     * @param id The ID of the driver to be deleted.
     * @return A message indicating the result of the deletion operation.
     */
    @DeleteMapping("/deletedriver")
    public String deleteDriver(@RequestBody int id){
        if(driverService.deleteDriver(id)){
            return "Driver deleted successfully";
        }else{
            return "Could not find user";
        }
    }

    @PatchMapping("/startWork")
    public void startWork(@RequestBody int id){
        driverService.startWork(id);
    }
    @PatchMapping("/stopWork")
    public void stopWork(@RequestBody int id){
        driverService.stopWork(id);
    }

    @GetMapping("/sendNotif")
    public void sendNotif(){
        driverService.sendNotif();
    }
}
