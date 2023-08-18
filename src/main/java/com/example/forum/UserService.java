package com.example.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User registerUser(String username, String password) {
        if (userMapper.getUserByUsername(username) != null) {
            return null;
        }

        // Create a new user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userMapper.createUser(user);
        return user;
    }

    public User authenticate(String username, String password) {
        User user = userMapper.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
