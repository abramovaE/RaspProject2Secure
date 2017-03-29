package com.springapp.mvc.controller;

import com.springapp.mvc.model.Raspberry;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.SecurityService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kot on 22.03.17.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
//
//
//
//    public void setSecurityService(SecurityService securityService) {
//        this.securityService = securityService;
//    }

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model){

        return "redirect: /";
    }



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("userlist", this.userService.getAllUsers());
        model.addAttribute("autorizedUser", this.securityService.findLoggedInusername());
        return "admin";
    }



    @RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
    public String saveRaspberry(Model model, @ModelAttribute("user") User user){

        String s = null;
        if(userService.findByUsername(user.getUsername())==null) {
            this.userService.save(user);
        }
//        else {
//            s = "user with this name already exists";
//        }
//
//        model.addAttribute("exist", s);
        return String.format("redirect: /admin");
    }



    @RequestMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        this.userService.delete(id);

        return String.format("redirect:/admin");
    }
}
