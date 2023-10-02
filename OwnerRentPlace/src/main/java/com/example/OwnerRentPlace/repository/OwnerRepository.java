package com.example.OwnerRentPlace.repository;

import com.example.OwnerRentPlace.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findOwnerByUsernameAndPassword(String username, String password);
}
