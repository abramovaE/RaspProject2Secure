package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;

import java.util.List;

/**
 * Created by kot on 22.03.17.
 */
public interface UserDao {
    public User findByUsername(String username);
    public void save(User user);

    public List<User> getAllUsers();
    public void delete(long id);
}
