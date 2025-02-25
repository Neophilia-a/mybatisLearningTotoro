package com.totoro.hibernate.service.impl;


import com.totoro.hibernate.dao.IUserDao;
import com.totoro.hibernate.model.User;
import com.totoro.hibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public List<User> query() {
        PageRequest pageRequest = PageRequest.of(1, 3);
        dao.findAll(null, pageRequest);
        return dao.findAll();
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }
}
