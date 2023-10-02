package com.example.UserRentPlace.repository;

import com.example.UserRentPlace.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findPropertyByLocation(String location);

    List<Property> findByRating(int rating);

    List<Property> findPropertyByType(String type);

    List<Property> findPropertyByFeatures(String features);

    List<Property> findPropertyByStart(String start);

    List<Property> findPropertyByEnd(String end);

    @Query(value = "select * from property p where p.location like %:keyword% ", nativeQuery = true)
    List<Property> findByKeyword(@Param("keyword") String keyword);

    @Query(value ="select * from property p where p.type like %:keyword% ", nativeQuery = true)
    List<Property> findByKeyWord(@Param("keyword") String keyword);

    @Query(value ="select * from property p where p.features like %:keyword% ", nativeQuery = true)
    List<Property> findByKeyWordd(@Param("keyword") String keyword);

    @Query(value ="select * from property p where p.start like %:keyword% ", nativeQuery = true)
    List<Property> findByKeyWordStart(@Param("keyword") String keyword);

    @Query(value ="select * from property p where p.end like %:keyword% ", nativeQuery = true)
    List<Property> findByKeyWordEnd(@Param("keyword") String keyword);

    @Query(value ="select * from property p where p.rating like %:keyword% ", nativeQuery = true)
    List<Property> findByKeyWordRating(@Param("keyword") int keyword);
}
