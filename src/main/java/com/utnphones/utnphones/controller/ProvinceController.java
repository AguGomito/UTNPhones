package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.exception.province.ProvinceAlreadyExistsException;
import com.utnphones.utnphones.exception.province.ProvinceDoNotExistsException;
import com.utnphones.utnphones.model.Province;
import com.utnphones.utnphones.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {

    private final ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping("/")
    public void add (@RequestBody Province province) {
        try {
            provinceService.add(province);
        } catch (ProvinceAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public List <Province> getAll () {
        return provinceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional <Province> getById (@PathVariable final Integer id) throws ProvinceDoNotExistsException {
        return provinceService.getById(id);
    }
}
