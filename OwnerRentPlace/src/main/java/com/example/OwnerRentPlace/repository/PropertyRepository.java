package com.example.OwnerRentPlace.repository;

import com.example.OwnerRentPlace.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

}