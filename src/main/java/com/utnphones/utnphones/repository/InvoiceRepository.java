package com.utnphones.utnphones.repository;

import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository <Invoice, Integer> {

}
