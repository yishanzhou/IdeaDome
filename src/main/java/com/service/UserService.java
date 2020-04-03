package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {
    public User login(String name, String pwd);

    public List<User> findSex(String sex);

    public List<User> findAll();
}
