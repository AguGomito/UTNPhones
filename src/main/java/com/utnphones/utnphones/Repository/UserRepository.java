package com.utnphones.utnphones.Repository;

import com.utnphones.utnphones.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
