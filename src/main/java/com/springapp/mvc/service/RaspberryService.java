package com.springapp.mvc.service;

import com.springapp.mvc.model.Raspberry;

import java.util.List;

/**
 * Created by kot on 07.03.17.
 */
public interface RaspberryService {
    public List<Raspberry> getAllRaspberries();
    public List<Raspberry> getWorkingRaspberries();

    public Raspberry findById(int id);
    public void updateRaspberry(Raspberry raspberry);


}
