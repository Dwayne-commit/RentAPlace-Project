package com.example.OwnerRentPlace.controller;

import com.example.OwnerRentPlace.model.Owner;
import com.example.OwnerRentPlace.model.Property;
import com.example.OwnerRentPlace.repository.OwnerRepository;
import com.example.OwnerRentPlace.repository.PropRepo;
import com.example.OwnerRentPlace.repository.PropertyRepository;
import com.example.OwnerRentPlace.service.OwnerService;
import com.example.OwnerRentPlace.service.PropertyService;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropRepo propRepo;

    @Autowired
    PropertyService propertyService;

    @Autowired
    OwnerService ownerService;
    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView nav = new ModelAndView("login");
        nav.addObject("owner", new Owner());
        return nav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("owner") Owner owner){
        Owner oauthOwner = ownerService.login(owner.getUsername(), owner.getPassword());
        System.out.println(oauthOwner);
        if(Objects.nonNull(oauthOwner)){
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
        nav.addObject("owner", new Owner());
        return nav;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerDo(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/register";
    }

    @RequestMapping("/register")
    public ModelAndView getRegister(){
        Owner owner = new Owner();
        return new ModelAndView("register","obj",owner);
    }

    @RequestMapping("/addOwner")
    public String addOwner(@ModelAttribute("owner") Owner owner){
        Random rnd = new Random();
        Long n = rnd.nextLong(50);
        Long b = Long.valueOf(n);
        if(b == owner.getId()){
            b++;
        }
        owner.setId(b);
        ownerRepository.save(owner);
        return "redirect:/login";
    }

    @GetMapping("/")
    public ModelAndView listProperties(){
        ModelAndView modelAndView = new ModelAndView("index");
       // List<Property> properties = propRepo.findAll();
        modelAndView.addObject("Prop", propertyService.getProperty());
        return modelAndView;
    }

    @GetMapping("/addProperty")
    public ModelAndView addProperty(){
        ModelAndView model = new ModelAndView("addProperty");
        model.addObject("property", new Property());
        return model;
    }

    @RequestMapping(value = {"/addProperty"}, method = RequestMethod.POST)
    public String PropertyAdd(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/addProperty";
    }

    @RequestMapping("/addProperty")
    public ModelAndView getProperty(){
        Property property = new Property();
        return new ModelAndView("register","obj",property);
    }

    @RequestMapping("/addPlaces")
    public String addProperty(@ModelAttribute("property") Property property){
        propertyRepository.save(property);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable("id") long id, Model model) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        propertyRepository.delete(property);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateProperty(@PathVariable("id") long id, Model model) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("property", property);
        propertyRepository.delete(property);
        return "update-property";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Property property, Model model) {
        property = new Property();
        property.setId(property.getId());
        property.setName(property.getName());
        property.setLocation(property.getLocation());
        property.setType(property.getType());
        property.setFeatures(property.getFeatures());
        property.setStatus(property.getStatus());
        property.setStart(property.getStart());
        property.setEnd(property.getEnd());
        property.setRating(property.getRating());
        propertyRepository.save(property);
        return "redirect:/index";
    }
}
