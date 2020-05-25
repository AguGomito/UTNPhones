package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICityRepository extends JpaRepository <City, Integer> {

    @Query (value = "SELECT * FROM users u INNER JOIN cities c ON u.city_id = c.city_id", nativeQuery = true)
    Optional <City> findByUserId(Integer id);

    Optional <City> findByName(String name);
}
