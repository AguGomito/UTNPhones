package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.Rate;
import com.utnphones.utnphones.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void addRate (Rate rate) {
        rateRepository.save(rate);
    }

    public List <Rate> getAll () {
        return rateRepository.findAll();
    }
}
