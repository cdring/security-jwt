package com.chen.demo.service;

import com.chen.demo.dto.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}