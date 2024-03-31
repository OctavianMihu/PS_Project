package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing User entities.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * Adds a new user.
     *
     * @param user The user object to be added.
     * @return A message indicating that a new user has been added.
     */
    @PutMapping("/add")
    public String addUser(@RequestBody User user){
        userService.saveUser(user);
        return "New user added";
    }


    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    @GetMapping("/getall")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    /**
     * Deletes a user by ID.
     *
     * @param id The ID of the user to be deleted.
     * @return A message indicating the result of the deletion operation.
     */
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody int id){
        if(userService.deleteUser(id)){
            return "User deleted successfully";
        }else{
            return "Could not find user";
        }

    }

}
