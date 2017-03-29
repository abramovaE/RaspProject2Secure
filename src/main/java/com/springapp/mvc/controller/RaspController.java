package com.springapp.mvc.controller;

import com.springapp.mvc.model.Raspberry;
import com.springapp.mvc.service.RaspberryService;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kot on 07.03.17.
 */
@Controller
public class RaspController {

    private RaspberryService raspberryService;


    @Autowired(required = true)
    @Qualifier(value = "raspberryService")
    public void setRaspberryService(RaspberryService raspberryService) {
        this.raspberryService = raspberryService;
    }


    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String listRaspberries(Model model){
        Raspberry r = new Raspberry();
        model.addAttribute("raspberry", r);
        model.addAttribute("raspberries", this.raspberryService.getAllRaspberries());
        int workingCount = this.raspberryService.getWorkingRaspberries().size();
        model.addAttribute("workingRaspberries", workingCount);
        model.addAttribute("notWorkingraspberries", this.raspberryService.getAllRaspberries().size()-workingCount);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        model.addAttribute("date", simpleDateFormat.format(date));

//
//        String downtime = getTimeDiff(r.getDowntime());
//        String uptime = getTimeDiff(r.getUptime());
//        model.addAttribute("down", downtime);
//        model.addAttribute("up", uptime);

        return "main";
    }

    @RequestMapping(value = "/editraspberry/{id}", method = RequestMethod.GET)
    public String editRaspberry(@PathVariable("id") int id,  Model model){
        Raspberry raspberry = (Raspberry)this.raspberryService.findById(id);
        model.addAttribute("raspberry", raspberry);
        return "editraspberry";
    }


    @RequestMapping(value = "/main/save", method = RequestMethod.POST)
    public String saveRaspberry(@ModelAttribute("raspberry") Raspberry raspberry){
      this.raspberryService.updateRaspberry(raspberry);
        return String.format("redirect: /main");
    }

//    public String getTimeDiff(int sec){
//        int days = sec/86400;
//        int hours = (sec-days*86400)/24;
//        int minutes = (sec-days*86400-hours*24)/60;
//        int seconds = (sec-days/86400-hours*24-minutes*60);
//        return ("days"+sec);
//    }


}

