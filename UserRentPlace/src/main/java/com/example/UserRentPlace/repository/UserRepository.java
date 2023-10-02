package com.example.UserRentPlace.repository;

import com.example.UserRentPlace.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsernameAndPassword(String username, String password);
}