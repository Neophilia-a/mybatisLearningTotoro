package com.totoro.hibernate.service;

import com.totoro.hibernate.model.User;

import java.util.List;

public interface IUserService {

    public List<User> query();

    public User save(User user);
}