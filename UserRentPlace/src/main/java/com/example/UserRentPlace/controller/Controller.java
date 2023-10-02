package com.example.UserRentPlace.controller;

import com.example.UserRentPlace.model.Property;
import com.example.UserRentPlace.model.User;
import com.example.UserRentPlace.repository.PropertyRepository;
import com.example.UserRentPlace.repository.UserRepository;
import com.example.UserRentPlace.service.PropertyService;
import com.example.UserRentPlace.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView nav = new ModelAndView("login");
        nav.addObject("owner", new User());
        return nav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("owner") User user){
        User oauthUser = userService.login(user.getUsername(), user.getPassword());
        System.out.println(oauthUser);
        if(Objects.nonNull(oauthUser)){
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/login";
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView nav = new ModelAndView("register");
        nav.addObject("user", new User());
        return nav;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerDo(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/register";
    }

    @RequestMapping("/register")
    public ModelAndView getRegister(){
        User user = new User();
        return new ModelAndView("register","obj",user);
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        Random rnd = new Random();
        Long n = rnd.nextLong(50);
        Long b = Long.valueOf(n);
        if(b == user.getId()){
            b++;
        }
        user.setId(b);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/")
    public ModelAndView listProperties(String keyword, String val){
        ModelAndView modelAndView = new ModelAndView("index");
        // List<Property> properties = propRepo.findAll();
        String t = String.valueOf(val);
        switch(t){
            case "location":
                if(keyword != null){
                    modelAndView.addObject("Prop", propertyService.findByKeyword(keyword));
                }
                break;
            case "type":
                if(keyword != null){
                    modelAndView.addObject("Prop", propertyService.findByKeyWord(keyword));
                }
                break;
            case "features":
                if(keyword != null){
                    modelAndView.addObject("Prop", propertyService.findByKeyWordd(keyword));
                }
                break;
            case "start":
                if(keyword != null){
                    modelAndView.addObject("Prop", propertyService.findByKeyWordStart(keyword));
                }
                break;
            case "end":
                if(keyword != null){
                    modelAndView.addObject("Prop", propertyService.findByKeyWordEnd(keyword));
                }
                break;
            case "rating":
                if(keyword != null){
                    modelAndView.addObject("Prop", propertyService.findByKeyWordRating(keyword));
                }
            case "null":
                modelAndView.addObject("Prop", propertyService.getProperty());
        }
        return modelAndView;
    }

    @GetMapping("/reserve/{id}")
    public String showReserveProperty(@PathVariable("id") Long id, Property property, Model model) {
        String stat = "Request Reservation";
        property.setStatus(stat);
        property = propertyService.updateStatus(property,id);
        propertyRepository.save(property);
        model.addAttribute("property", property);
        return "redirect:/";
    }
}
