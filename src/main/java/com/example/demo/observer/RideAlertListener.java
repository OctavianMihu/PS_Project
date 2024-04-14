package com.example.demo.observer;

import com.example.demo.model.Driver;

import java.util.List;

public class RideAlertListener implements EventListener {
    public static final List<Driver> drivers = null;
    private static int i = 0;
    public RideAlertListener(List<Driver> drivers) {
        this.drivers = drivers;
    }
    public static void addDriver(Driver driver){
        drivers.add(driver);
    }
    public void update()
    {
        System.out.println(i + ". Primit mesaj");
        i++;
    }
}
