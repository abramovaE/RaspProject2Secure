package com.springapp.mvc.service;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kot on 22.03.17.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        this.userDao.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void delete(long id) {
     this.userDao.delete(id);
    }


}
