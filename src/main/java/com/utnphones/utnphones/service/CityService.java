package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final ICityRepository cityRepository;

    @Autowired
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void addCity (City city) {
        cityRepository.save(city);
    }

    public List<City> getAll () {
        return cityRepository.findAll();
    }
}
