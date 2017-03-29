package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kot on 22.03.17.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByUsername(String s) {
        Session session = this.sessionFactory.getCurrentSession();



        User user = new User();
        user.setUsername(s);


//        List<User> list = (List<User>) session.createQuery("from User").list();

        List<User> list = session.createCriteria(User.class).add(Example.create(user)).list();




//        for(User u:list){
//            if(u.getUsername().compareTo(s)==0){
//                return u;
//
//            }
//        }

        if(!list.isEmpty()) {
            return list.get(0);
        }

        else {return null;}
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();


        session.save(user);


    }

    @Override
    public List<User> getAllUsers() {
        Session session=this.sessionFactory.getCurrentSession();
        List<User> list = (List<User>) session.createQuery("from User").list();
        return list;
    }

    @Override
    public void delete(long id) {
        Session session = this.sessionFactory.getCurrentSession();

        User u = (User) session.load(User.class, new Long(id));

        if(u!=null) {
            session.delete(u);
        }
    }
}
