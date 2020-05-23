package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.Rate;
import com.utnphones.utnphones.repository.IRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    private final IRateRepository rateRepository;

    @Autowired
    public RateService(IRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void addRate (Rate rate) {
        rateRepository.save(rate);
    }

    public List <Rate> getAll () {
        return rateRepository.findAll();
    }
}
