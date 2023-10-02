package com.example.OwnerRentPlace.service;

import com.example.OwnerRentPlace.model.Property;
import com.example.OwnerRentPlace.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {

    public Property createProperty(Property property);

    public List<Property> getProperty();

    public Property getPropertyById(Long id);

    public void deleteProperty(Long id);

    public Property updateProperty(Property property, Long id);

    public List<Property> getProp();

}
