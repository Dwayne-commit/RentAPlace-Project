package com.example.UserRentPlace.repository;

import com.example.UserRentPlace.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropRepo extends CrudRepository<Property, Long> {
}
