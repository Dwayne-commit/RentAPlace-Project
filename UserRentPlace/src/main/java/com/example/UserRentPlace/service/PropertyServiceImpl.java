package com.example.UserRentPlace.service;

import com.example.UserRentPlace.model.Property;
import com.example.UserRentPlace.repository.PropRepo;
import com.example.UserRentPlace.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropRepo propRepo;


    @Override
    public List<Property> getProperty(){
        return (List<Property>) propertyRepository.findAll();
    }

    @Override
    public List<Property> getPropertyByRatings(int rating) {
        return (List<Property>) propertyRepository.findByRating(rating);
    }

    @Override
    public Property updateStatus(Property property, Long id) {
        Property prop1 = propRepo.findById(id).get();
        prop1.setStatus(property.getStatus());
        return propertyRepository.save(prop1);
    }


    public List<Property> findByKeyword(String keyword){
        return propertyRepository.findByKeyword(keyword);
    }

    public List<Property> findByKeyWord(String keyword){
        return propertyRepository.findByKeyWord(keyword);
    }

    public List<Property> findByKeyWordd(String keyword){
        return propertyRepository.findByKeyWordd(keyword);
    }

    public List<Property> findByKeyWordStart(String keyword){
        return propertyRepository.findByKeyWordStart(keyword);
    }

    public List<Property> findByKeyWordEnd(String keyword){
        return propertyRepository.findByKeyWord(keyword);
    }

    public List<Property> findByKeyWordRating(String keyword){
        int b = Integer.valueOf(keyword);
        return propertyRepository.findByKeyWordRating(b);
    }
}