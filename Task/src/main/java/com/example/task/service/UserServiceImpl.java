package com.example.task.service;

import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Cacheable(value = "usersCache")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "usersCache")
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Cacheable(value = "usersCache")
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
