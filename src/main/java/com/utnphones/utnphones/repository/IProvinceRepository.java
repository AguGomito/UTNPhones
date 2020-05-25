package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface IProvinceRepository extends JpaRepository <Province, Integer> {

    @Query (value = "SELECT FROM users u " + "INNER JOIN cities c ON u.city_id = c.city_id "
            + "INNER JOIN provinces p on p.province_id = c.city_id " + "WHERE u.id = ?1", nativeQuery = true)
    Optional <Province> findUserByUserId (Integer id);

    Optional <Province> findByName(String name);

}
