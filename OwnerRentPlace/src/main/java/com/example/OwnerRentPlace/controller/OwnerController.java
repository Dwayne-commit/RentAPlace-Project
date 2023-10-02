package com.example.OwnerRentPlace.controller;

import com.example.OwnerRentPlace.model.Owner;
import com.example.OwnerRentPlace.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PutMapping("/add")
    public Owner createOwner(@RequestBody Owner owner){
        Owner owner1 = ownerService.createOwner(owner);
        return owner1;
    }

    @GetMapping("/owner")
    public List<Owner> getOwners(){
        return ownerService.getOwners();
    }

    @PutMapping("/update-owner/{id}")
    public Owner updateOwnerById(@RequestBody Owner owner, @PathVariable("id") Long id){
        return ownerService.updateOwner(owner, id);
    }

    @GetMapping("/getOwner/{id}")
    public Owner getOwnerById(@PathVariable("id") Long id){
        return ownerService.getOwnerById(id);
    }
}
