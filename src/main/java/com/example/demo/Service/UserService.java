package com.example.demo.Service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing User entities.
 */
public interface UserService {

    /**
     * Saves a user entity.
     *
     * @param user The user object to be saved.
     * @return The saved user object.
     */
    User saveUser(User user);

    /**
     * Retrieves a list of all users.
     *
     * @return A list containing all users.
     */
    List<User> getAllUsers();

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user to find.
     * @return An Optional containing the user if found, otherwise empty.
     */
    Optional<User> findByID(int id);

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return True if the user was successfully deleted, false otherwise.
     */
    boolean deleteUser(int id);

    /**
     * Notifies the system that a user wants a ride.
     *
     * @param id The ID of the user who wants a ride.
     */
    void wantsRide(int id);

    /**
     * Notifies the system that a ride is over for a user.
     *
     * @param id The ID of the user for whom the ride is over.
     */
    void rideOver(int id);
}
