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
    @PostMapping("/adddriver")
    public String addUser(@RequestBody Driver driver){
        driverService.saveDriver(driver);
        return "New driver added";
    }

    @GetMapping("/getalldriver")
    public List<Driver> getAllUsers(){
        return driverService.getAllDrivers();
    }
    @DeleteMapping("/deletedriver")
    public String deleteUser(@RequestBody int id){
        return "";
    }

}
