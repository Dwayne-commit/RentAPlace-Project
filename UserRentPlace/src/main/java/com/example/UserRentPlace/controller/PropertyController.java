package com.example.UserRentPlace.controller;

import com.example.UserRentPlace.model.Property;
import com.example.UserRentPlace.model.User;
import com.example.UserRentPlace.repository.PropertyRepository;
import com.example.UserRentPlace.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyService propertyService;

    @GetMapping(value = {"/location/{uf}"})
    public List<Property> findByUF(@PathVariable String uf){
        return propertyRepository.findPropertyByLocation(uf);
    }

    @GetMapping(value = {"/rating/{rating}"})
    public List<Property> findByRate(@PathVariable int rating){
        return propertyService.getPropertyByRatings(rating);
    }

    @PutMapping(value = {"/status/{id}"})
    public Property updateStat(@RequestBody Property property, @PathVariable("id") Long id){
        return propertyService.updateStatus(property, id);
    }

    @GetMapping(value = {"/type/{type}"})
    public List<Property> findByType(@PathVariable String type){
        return propertyRepository.findPropertyByType(type);
    }

    @GetMapping(value = {"/features/{features}"})
    public List<Property> findByFeatures(@PathVariable String features){
        return propertyRepository.findPropertyByFeatures(features);
    }

    @GetMapping(value = {"/start/{start}"})
    public List<Property> findByStart(@PathVariable String start){
        return propertyRepository.findPropertyByStart(start);
    }

    @GetMapping(value = {"/end/{end}"})
    public List<Property> findByEnd(@PathVariable String end){
        return propertyRepository.findPropertyByEnd(end);
    }
}

