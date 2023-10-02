package com.example.OwnerRentPlace.service;

import com.example.OwnerRentPlace.model.Owner;
import com.example.OwnerRentPlace.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getOwners(){
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id){
        return ownerRepository.findById(id).get();
    }

    @Override
    public Owner updateOwner(Owner owner, Long id){
        Owner owner1 = ownerRepository.findById(id).get();
        owner1.setEmail(owner.getEmail());
        owner1.setUsername(owner.getUsername());
        owner1.setPassword(owner.getPassword());
        return ownerRepository.save(owner1);
    }

    @Override
    public Owner login(String username, String password){
        Owner owner = ownerRepository.findOwnerByUsernameAndPassword(username, password);
        return owner;
    }
}
