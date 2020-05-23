package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRateRepository extends JpaRepository <Rate, Integer> {

}
