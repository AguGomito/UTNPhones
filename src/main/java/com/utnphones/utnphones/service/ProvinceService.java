package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.Province;
import com.utnphones.utnphones.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    private final IProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(IProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public void addProvince (Province province) {
        provinceRepository.save(province);
    }

    public List<Province> getAll () {
        return provinceRepository.findAll();
    }

}
