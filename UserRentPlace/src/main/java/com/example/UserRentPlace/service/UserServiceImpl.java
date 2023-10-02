package com.example.UserRentPlace.service;

import com.example.UserRentPlace.model.User;
import com.example.UserRentPlace.repository.UserRepository;
import com.example.UserRentPlace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    @Override
    public User login(String username, String password){
        User owner = userRepository.findUserByUsernameAndPassword(username, password);
        return owner;
    }

    @Override
    public User updateUser(User user, Long id){
        User user1 = userRepository.findById(id).get();
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return userRepository.save(user1);
    }
}
