package com.example.UserRentPlace.service;

import com.example.UserRentPlace.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

    public List<User> getUsers();

    public User getUserById(Long id);

    public User updateUser(User user, Long id);

    public User login(String username, String password);
}
