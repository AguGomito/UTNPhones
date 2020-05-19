package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.PhoneLine;
import com.utnphones.utnphones.repository.PhoneLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneLineService {

    private final PhoneLineRepository phoneLineRepository;

    @Autowired
    public PhoneLineService(PhoneLineRepository phoneLineRepository) {
        this.phoneLineRepository = phoneLineRepository;
    }

    public void addPhoneLine (PhoneLine phoneLine) {
        phoneLineRepository.save(phoneLine);
    }

    public List<PhoneLine> getAll () {
        return phoneLineRepository.findAll();
    }
}
