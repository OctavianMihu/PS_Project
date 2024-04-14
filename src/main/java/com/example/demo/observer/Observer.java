package com.example.demo.observer;

public class Observer {
    private final NotificationService notificationService;

    public Observer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public void foundWork(){
        notificationService.notifyDrivers();
    }
    public NotificationService getService(){
        return notificationService;
    }
}
