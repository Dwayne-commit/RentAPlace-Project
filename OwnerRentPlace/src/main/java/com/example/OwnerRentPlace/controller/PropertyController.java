package com.example.OwnerRentPlace.controller;

import com.example.OwnerRentPlace.model.Property;
import com.example.OwnerRentPlace.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PutMapping("/postProperty")
    public Property createProperty(@RequestBody Property property){
        Property prop1 =  propertyService.createProperty(property);
        return prop1;
    }

    @GetMapping("/properties")
    public List<Property> getProperty(){
        return propertyService.getProperty();
    }


    @PutMapping("/updateProperty/{id}")
    public Property updatePropertyById(@RequestBody Property property, @PathVariable("id") Long id){
        return propertyService.updateProperty(property, id);
    }

    @DeleteMapping("/deleteProperty/{id}")
    public String deleteProperty(@PathVariable("id") Long id){
        propertyService.deleteProperty(id);
        return "Property Deleted";
    }

    @GetMapping("/property/{id}")
    public Property getPropertyById(@PathVariable("id") Long id){
        return propertyService.getPropertyById(id);
    }
}
