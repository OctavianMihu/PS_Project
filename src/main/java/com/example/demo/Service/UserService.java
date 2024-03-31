package com.example.demo.Service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    List<User> getAllUsers();

}
