package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.model.Rate;
import com.utnphones.utnphones.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rate")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping("/")
    public void addRate (@RequestBody Rate rate) {
        rateService.addRate(rate);
    }

    @GetMapping("/")
    public List <Rate> getAll () {
        return rateService.getAll();
    }
}
