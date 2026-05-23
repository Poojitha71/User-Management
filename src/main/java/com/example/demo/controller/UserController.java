package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add/Users")
    public UserResponse addUser(@Valid @RequestBody UserRequest request) {
        return service.saveUser(request);
    }

    @GetMapping("/get/users")
    public List<UserResponse> getUsers() {
        return service.getAllUsers();
    }
    
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}