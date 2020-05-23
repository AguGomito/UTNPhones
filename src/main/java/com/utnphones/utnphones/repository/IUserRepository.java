package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository <User, Integer> {

}
