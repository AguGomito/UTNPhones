package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.exception.city.CityAlreadyExistsException;
import com.utnphones.utnphones.exception.city.CityDoNotExistsException;
import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/")
    public void addCity (@RequestBody City city) {
        try {
            cityService.add(city);
        } catch (CityAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public List <City> getAll () {
        return cityService.getAll();
    }

    @PostMapping("/{id}")
    public Optional <City> getById (@PathVariable final Integer id) throws CityDoNotExistsException {
        return cityService.getById(id);
    }

    @GetMapping("/user/{id}")
    public Optional <City> getByUserId (@PathVariable final Integer id) {
        return cityService.getByUserId(id);
    }
}
