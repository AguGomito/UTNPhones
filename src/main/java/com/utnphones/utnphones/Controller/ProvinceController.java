package com.utnphones.utnphones.Controller;

import com.utnphones.utnphones.Model.Province;
import com.utnphones.utnphones.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    private final ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping("/")
    public void addProvince (@RequestBody Province province) {
        provinceService.addProvince(province);
    }

    @GetMapping("/")
    public List <Province> getAll () {
        return provinceService.getAll();
    }
}
