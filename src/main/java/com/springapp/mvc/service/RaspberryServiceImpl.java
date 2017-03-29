package com.springapp.mvc.service;

import com.springapp.mvc.dao.RaspberryDao;
import com.springapp.mvc.model.Raspberry;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RaspberryServiceImpl implements RaspberryService{


    private RaspberryDao raspberryDao;

    public void setRaspberryDao(RaspberryDao raspberryDao) {
        this.raspberryDao = raspberryDao;
    }

    @Override
    @Transactional
    public List<Raspberry> getAllRaspberries() {
        return this.raspberryDao.getAllRaspberries();
    }

    @Override
    @Transactional
    public List<Raspberry> getWorkingRaspberries() {
        return this.raspberryDao.getWorkingRaspberries();
    }

    @Override
    @Transactional
    public Raspberry findById(int id) {
        return this.raspberryDao.findById(id);
    }

    @Override
    @Transactional
    public void updateRaspberry(Raspberry raspberry) {
        this.raspberryDao.updateRaspberry(raspberry);
    }




}
