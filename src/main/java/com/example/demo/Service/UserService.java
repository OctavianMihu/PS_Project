package com.example.demo.Service;


import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;
/**
 * Service interface for managing User entities.
 */
public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUsers();

    public Optional<User> findByID(int id);
    public boolean deleteUser(int id);

}
