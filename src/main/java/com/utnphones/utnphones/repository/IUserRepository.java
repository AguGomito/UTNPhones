package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IUserRepository extends JpaRepository <User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE users u SET u.is_active = false WHERE u.user_id = ?1", nativeQuery = true)
    Integer disableById(Integer id);

    Optional <User> findByName(String name);

    Boolean findByUsername(String name);

    Optional <User> findByDni (String dni);

    Optional <User> findByUsernameAndPassword (String username, String password);
}
