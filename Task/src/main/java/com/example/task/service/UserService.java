package com.example.task.service;

import com.example.task.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void registerUser(User user);
    User findUserByUsername(String username);
}
