package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserResponse saveUser(UserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User saved = repo.save(user);

        UserResponse response = new UserResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());

        return response;
    }

    public List<UserResponse> getAllUsers() {

        List<User> users = repo.findAll();

        return users.stream().map(user -> {
            UserResponse res = new UserResponse();
            res.setId(user.getId());
            res.setName(user.getName());
            res.setEmail(user.getEmail());
            return res;
        }).toList();
    }
    
    public User updateUser(Long id, User user) {
        User existing = repo.findById(id).orElseThrow();
        
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        
        return repo.save(existing);
    }
    
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}