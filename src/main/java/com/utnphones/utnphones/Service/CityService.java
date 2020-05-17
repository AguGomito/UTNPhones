package com.utnphones.utnphones.Service;

import com.utnphones.utnphones.Model.City;
import com.utnphones.utnphones.Repository.CityRepository;
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
