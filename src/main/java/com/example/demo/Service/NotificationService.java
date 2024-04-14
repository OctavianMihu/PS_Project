package com.example.demo.Service;

import com.example.demo.model.Driver;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing notifications to drivers.
 */
public class NotificationService {
    private final List<DriverListener> drivers;

    /**
     * Constructor for NotificationService.
     * Initializes the list of driver listeners.
     */
    public NotificationService(){
        drivers = new ArrayList<>();
    }

    /**
     * Adds a driver listener for notification.
     *
     * @param d The driver listener to be added.
     */
    public void working(DriverListener d){
        drivers.add(d);
    }

    /**
     * Removes a driver listener.
     *
     * @param d The driver listener to be removed.
     */
    public void stoppedWorking(DriverListener d){
        drivers.remove(d);
    }

    /**
     * Sends notification to all registered driver listeners.
     */
    public void sendNotification() {
        drivers.forEach(DriverListener::update);
    }

}
