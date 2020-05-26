package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.PhoneLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IPhoneLineRepository extends JpaRepository <PhoneLine, Integer> {

    Optional <PhoneLine> findByPhoneNumber (String phoneNumber);

    @Transactional
    @Modifying
    @Query (value = "UPDATE phonelines p SET p.state = 0 WHERE p.line_id = ?1", nativeQuery = true)
    int disableById(Integer id);
}
