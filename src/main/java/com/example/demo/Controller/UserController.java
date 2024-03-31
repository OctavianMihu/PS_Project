package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.saveUser(user);
        return "New user added";
    }

    @GetMapping("/getall")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody int id){
//        int ID;
//        try{
//            ID = Integer.parseInt(id);
//        }catch(Exception e){
//            e.printStackTrace();
//            return "id not a number";
//        }
        if(userService.deleteUser(id)){
            return "User deleted successfully";
        }else{
            return "Could not find user";
        }

    }

}
