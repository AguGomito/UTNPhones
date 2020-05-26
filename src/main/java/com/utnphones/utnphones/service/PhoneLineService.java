package com.utnphones.utnphones.service;

import com.utnphones.utnphones.exception.phoneLine.LineAlreadExistsException;
import com.utnphones.utnphones.exception.phoneLine.NumberNotRegisteredException;
import com.utnphones.utnphones.exception.phoneLine.PhoneDoNotExistsException;
import com.utnphones.utnphones.model.PhoneLine;
import com.utnphones.utnphones.repository.IPhoneLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneLineService {

    private final IPhoneLineRepository phoneLineRepository;

    @Autowired
    public PhoneLineService(IPhoneLineRepository phoneLineRepository) {
        this.phoneLineRepository = phoneLineRepository;
    }

    public void addPhoneLine (PhoneLine newPhoneLine) throws LineAlreadExistsException {
        Optional <PhoneLine> phoneLine = phoneLineRepository.findByPhoneNumber(newPhoneLine.getPhoneNumber());
        if (phoneLine.isPresent()) {
            throw new LineAlreadExistsException ("Phone number already in use");
        }
        phoneLineRepository.save(newPhoneLine);
    }

    public List<PhoneLine> getAll () {
        return phoneLineRepository.findAll();
    }

    public Optional <PhoneLine> getByNumber (String number) throws NumberNotRegisteredException {
        Optional <PhoneLine> aux = phoneLineRepository.findByPhoneNumber(number);
        if (!(aux.isPresent())) {
            throw new NumberNotRegisteredException("The number does not exists");
        }
        return aux;
    }

    public Optional <PhoneLine> getById(Integer id) throws PhoneDoNotExistsException {
        Optional <PhoneLine> phoneLine = phoneLineRepository.findById(id);
        if (!(phoneLine.isPresent())) {
            throw new PhoneDoNotExistsException("The phoneline do not exists");
        }
        return phoneLine;
    }

    public int disableById(Integer id) throws PhoneDoNotExistsException {
        Optional <PhoneLine> phoneLine = phoneLineRepository.findById(id);
        if (!(phoneLine.isPresent())) {
            throw new PhoneDoNotExistsException("The phoneline do not exisits");
        }
        return phoneLineRepository.disableById(id);
    }
}
