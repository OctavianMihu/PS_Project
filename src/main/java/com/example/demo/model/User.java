package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;



/**
 * Represents a user entity in the system.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String username;
    private String email;
    private boolean wantsRide;

    public User(int ID, String username, String email, boolean wantsRide) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.wantsRide = wantsRide;
    }

    public User(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isWantsRide() {
        return wantsRide;
    }

    public void setWantsRide(boolean wantsRide) {
        this.wantsRide = wantsRide;
    }
}
