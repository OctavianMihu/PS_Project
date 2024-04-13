package com.example.demo.Service;


import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing User entities.
 */
public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    Optional<User> findByID(int id);

    boolean deleteUser(int id);

}
