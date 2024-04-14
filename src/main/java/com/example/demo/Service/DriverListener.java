package com.example.demo.Service;

public class DriverListener {
    private final int id;
    public static int i = 0;

    public DriverListener(int id) {
        this.id = id;
    }
    public void update(){
        System.out.println(i +". Recieved update");
        i++;
    }
}
