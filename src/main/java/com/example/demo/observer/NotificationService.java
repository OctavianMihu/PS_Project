package com.example.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<RideAlertListener> drivers;

    public NotificationService() {
        this.drivers = new ArrayList<>();
    }
    public void startWork(RideAlertListener listener){
        drivers.add(listener);
    }
    public void stopWork(RideAlertListener listener) {
        drivers.remove(listener);
    }
    public void notifyDrivers(){
        drivers.forEach(listener -> listener.update());
    }
}
