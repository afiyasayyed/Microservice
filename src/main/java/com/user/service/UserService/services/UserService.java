package com.user.service.UserService.services;

import com.user.service.UserService.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(String userId);
    void deleteUser(String userId);

}
