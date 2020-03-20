package com.dolphin.security.system.service;

import com.dolphin.security.system.entity.User;
import com.dolphin.security.system.enums.UserStatus;
import com.dolphin.security.system.exception.UserNameAlreadyExistException;
import com.dolphin.security.system.repository.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shuang.kou
 */
@Service
public class UserService {
    @Autowired
    private final UserDao userDao;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(Map<String, String> registerUser) {
        User userRes = userDao.findByUsername(registerUser.get("username"));
        if (userRes!= null) {
            throw new UserNameAlreadyExistException("User name already exist!Please choose another user name.");
        }
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("DEV,PM");
        user.setStatus(UserStatus.CAN_USE);
        userDao.insert(user);
    }

    public User findUserByUserName(String name) {
        User user = userDao.findByUsername(name);
        if (null == user) {
            throw new UsernameNotFoundException("No user found with username " + name);
        } else {
            return user;
        }
    }

    public void deleteUserByUserName(String name) {
        userDao.deleteByUsername(name);
    }


    public PageInfo<User> getAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userDao.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return  pageInfo;
    }
}
