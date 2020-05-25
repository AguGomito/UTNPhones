package com.utnphones.utnphones.service;

import com.utnphones.utnphones.exception.city.CityAlreadyExistsException;
import com.utnphones.utnphones.exception.city.CityDoNotExistsException;
import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final ICityRepository cityRepository;

    @Autowired
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void add (City newCity) throws CityAlreadyExistsException {
        Optional <City> city = cityRepository.findByName(newCity.getName());
        if (city.isPresent()) {
            throw new CityAlreadyExistsException("The city already exists");
        }
        cityRepository.save(newCity);
    }

    public List<City> getAll () {
        return cityRepository.findAll();
    }

    public Optional<City> getById (Integer id) throws CityDoNotExistsException {
        Optional <City> city = cityRepository.findById(id);
        if (!(city.isPresent())) {
            throw new CityDoNotExistsException("The city does not exists");
        }
        return city;
    }

    public Optional <City> getByUserId (Integer id) {
        return cityRepository.findByUserId(id);
    }
}
