package com.user.service.UserService.controller;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/newUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String userId){
        Optional<User> fetchedUser = userService.getUserById(userId);
        return ResponseEntity.ok(fetchedUser);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser(){
        List<User> fetchedUsers = userService.getAllUsers();
        return ResponseEntity.ok(fetchedUsers);
    }
}
