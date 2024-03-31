package com.example.demo.Service;

import com.example.demo.Repo.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of UserService interface providing CRUD operations for User entities.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByID(int id) {return userRepository.findById(id);}

    @Override
    public boolean deleteUser(int id) {
        Optional<User> u = findByID(id);
        if(u.isPresent()){
            User user = u.get();
            userRepository.delete(user);
            return true;
            //String displayName = pageDetail.map(PageDetail::getName).orElse(uri);
        }
        return false;
    }


}
