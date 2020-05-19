package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.model.City;
import com.utnphones.utnphones.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/")
    public void addCity (@RequestBody City city) {
        cityService.addCity(city);
    }

    @GetMapping("/")
    public List <City> getAll () {
        return cityService.getAll();
    }
}
