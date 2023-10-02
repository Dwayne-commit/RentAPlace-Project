package com.example.OwnerRentPlace.model;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class Property {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "location")
    String location;
    @Column(name = "type")
    String type;
    @Column(name = "features")
    String features;
    @Column(name = "status")
    String status;
    @Column(name = "start")
    String start;
    @Column(name = "end")
    String end;
    @Column(name = "rating")
    int rating;

    public Property(){}

    public Property(Long id, String name, String location, String type, String features, String status, String start, String end, int rating){
        this.id = id;
        this.name = name;
        this.type = type;
        this.features = features;
        this.status = status;
        this.start = start;
        this.end = end;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
