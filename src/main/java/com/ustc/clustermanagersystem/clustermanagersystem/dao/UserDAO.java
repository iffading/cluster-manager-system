package com.ustc.clustermanagersystem.clustermanagersystem.dao;

import com.ustc.clustermanagersystem.clustermanagersystem.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
}
