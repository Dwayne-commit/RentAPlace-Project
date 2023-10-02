package com.example.UserRentPlace.service;

import com.example.UserRentPlace.model.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {

    public List<Property> getPropertyByRatings(int rating);

    public Property updateStatus(Property property, Long id);

    public List<Property> getProperty();

    public List<Property> findByKeyword(String keyword);

    public List<Property> findByKeyWord(String keyword);

    public List<Property> findByKeyWordd(String keyword);

    public List<Property> findByKeyWordStart(String keyword);

    public List<Property> findByKeyWordEnd(String keyword);

    public List<Property> findByKeyWordRating(String keyword);
}
