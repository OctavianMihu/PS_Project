package com.example.demo.observer;

public class RideAlertListener implements EventListener {
    private final boolean isDriving;
    private final boolean isWorking;

    public RideAlertListener(boolean isDriving, boolean isWorking) {
        this.isDriving = isDriving;
        this.isWorking = isWorking;
    }
    public void update(){

    }
}
