package com.example.demo.Service;

/**
 * Class representing a listener for driver updates.
 */
public class DriverListener {
    private final int id;
    public static int i = 0;

    /**
     * Constructor for DriverListener.
     *
     * @param id The ID of the driver this listener is associated with.
     */
    public DriverListener(int id) {
        this.id = id;
    }

    /**
     * Updates the listener.
     */
    public void update(){
        System.out.println(i +". Received update");
        i++;
    }
}
