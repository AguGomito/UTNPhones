package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICallRepository extends JpaRepository <Call, Integer> {
}
