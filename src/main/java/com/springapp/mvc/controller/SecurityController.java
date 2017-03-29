package com.springapp.mvc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kot on 22.03.17.
 */
@Controller
public class SecurityController {

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout){
//        if(error!=null){
//            model.addAttribute("error", "Username or password is incorrect.");
//        }
//
//        if(logout!=null){
//            model.addAttribute("message", "Logged out successfully.");
//        }
//
//        return "login";
//    }
//
//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model){
//        return "welcome";
//    }
//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String admin(Model model){
//        return "admin";
//    }
}
