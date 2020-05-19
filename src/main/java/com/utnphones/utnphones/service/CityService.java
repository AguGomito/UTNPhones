package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void addCity (City city) {
        cityRepository.save(city);
    }

    public List<City> getAll () {
        return cityRepository.findAll();
    }
}