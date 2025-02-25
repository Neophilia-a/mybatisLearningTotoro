package com.totoro.hibernate.dao;

import com.totoro.hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {
}