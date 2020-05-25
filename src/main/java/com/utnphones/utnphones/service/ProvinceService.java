package com.utnphones.utnphones.service;

import com.utnphones.utnphones.exception.province.ProvinceAlreadyExistsException;
import com.utnphones.utnphones.exception.province.ProvinceDoNotExistsException;
import com.utnphones.utnphones.model.Province;
import com.utnphones.utnphones.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {

    private final IProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(IProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public void add (Province newProvince) throws ProvinceAlreadyExistsException {
        Optional <Province> province = provinceRepository.findByName(newProvince.getName());
        if (province.isPresent()) {
            throw new ProvinceAlreadyExistsException("The province already exists");
        }
        provinceRepository.save(newProvince);
    }

    public List<Province> getAll () {
        return provinceRepository.findAll();
    }

    public Optional <Province> getById (Integer id) throws ProvinceDoNotExistsException {
        Optional <Province> province = provinceRepository.findById(id);
        if (!(province.isPresent())) {
            throw new ProvinceDoNotExistsException("The province does not exists");
        }
        return province;
    }

}
