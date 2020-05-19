package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {

}
