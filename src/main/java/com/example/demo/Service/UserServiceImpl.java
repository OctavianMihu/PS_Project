package com.example.demo.Service;

import com.example.demo.Repo.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of UserService interface providing CRUD operations for User entities.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Saves a user entity.
     *
     * @param user The user object to be saved.
     * @return The saved user object.
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list containing all users.
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user to find.
     * @return An Optional containing the user if found, otherwise empty.
     */
    @Override
    public Optional<User> findByID(int id) {
        return userRepository.findById(id);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return True if the user was successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteUser(int id) {
        Optional<User> u = findByID(id);
        if (u.isPresent()) {
            User user = u.get();
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public void wantsRide(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setWantsRide(true);
            userRepository.save(user);

        }

    }

    @Override
    public void rideOver(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setWantsRide(false);
            userRepository.save(user);
        }
    }

}