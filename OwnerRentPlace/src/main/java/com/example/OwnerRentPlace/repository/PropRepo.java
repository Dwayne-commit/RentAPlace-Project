package com.example.OwnerRentPlace.repository;

import com.example.OwnerRentPlace.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropRepo extends JpaRepository<Property, Long> {

}
