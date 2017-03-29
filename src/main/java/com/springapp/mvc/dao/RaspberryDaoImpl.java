package com.springapp.mvc.dao;

import com.springapp.mvc.model.Raspberry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RaspberryDaoImpl implements RaspberryDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Raspberry> getAllRaspberries() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Raspberry> raspberries = session.createQuery("from Raspberry").list();
        return raspberries;
    }

    @Override
    public List<Raspberry> getWorkingRaspberries() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Raspberry> workingRaspberries = session.createQuery("from Raspberry where isWork = true ").list();
        return workingRaspberries;
    }

    @Override
    public Raspberry findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Raspberry raspberry = (Raspberry) session.get(Raspberry.class, new Integer(id));
        return raspberry;
    }

    @Override
    public void updateRaspberry(Raspberry raspberry) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(raspberry);
    }


}
