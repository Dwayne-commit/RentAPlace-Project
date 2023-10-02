package com.example.OwnerRentPlace.service;

import com.example.OwnerRentPlace.model.Property;
import com.example.OwnerRentPlace.repository.OwnerRepository;
import com.example.OwnerRentPlace.repository.PropRepo;
import com.example.OwnerRentPlace.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.owner;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropRepo propRepo;

    @Override
    public Property createProperty(Property property){
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getProperty(){
        return (List<Property>) propertyRepository.findAll();
    }

    public List<Property> getProp(){ return propRepo.findAll(); }

    @Override
    public Property getPropertyById(Long id){
        return propertyRepository.findById(id).get();
    }

    @Override
    public void deleteProperty(Long id){
        propertyRepository.deleteById(id);
    }

    @Override
    public Property updateProperty(Property property, Long id){
        Property property1 = propertyRepository.findById(id).get();
        property1.setName(property.getName());
        property1.setFeatures(property.getFeatures());
        property1.setRating(property.getRating());
        property1.setType(property.getType());
        property1.setStatus(property.getStatus());
        property1.setStart(property.getStart());
        property1.setEnd(property.getEnd());
        property1.setLocation(property.getLocation());
        return propertyRepository.save(property1);
    }
}
