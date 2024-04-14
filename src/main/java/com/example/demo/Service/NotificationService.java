package com.example.demo.Service;

import com.example.demo.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<DriverListener> drivers;

    public NotificationService(){
        drivers = new ArrayList<>();
    }
    public void working(DriverListener d){
        drivers.add(d);
    }
    public void stoppedWorking(DriverListener d){
        drivers.remove(d);
    }

    public void sendNotification() {
        drivers.forEach(DriverListener::update);
    }

}
