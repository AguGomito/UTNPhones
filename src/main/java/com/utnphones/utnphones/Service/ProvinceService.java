package com.utnphones.utnphones.Service;

import com.utnphones.utnphones.Model.Province;
import com.utnphones.utnphones.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public void addProvince (Province province) {
        provinceRepository.save(province);
    }

    public List<Province> getAll () {
        return provinceRepository.findAll();
    }

}
