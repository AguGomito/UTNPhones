package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.exception.phoneLine.LineAlreadExistsException;
import com.utnphones.utnphones.exception.phoneLine.PhoneDoNotExistsException;
import com.utnphones.utnphones.model.PhoneLine;
import com.utnphones.utnphones.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phoneLine")
public class PhoneLineController {

    private final PhoneLineService phoneLineService;

    @Autowired
    public PhoneLineController(PhoneLineService phoneLineService) {
        this.phoneLineService = phoneLineService;
    }

    @PostMapping("/")
    public void addPhoneLine (@RequestBody PhoneLine phoneLine) {
        try {
            phoneLineService.addPhoneLine(phoneLine);
        } catch (LineAlreadExistsException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public List<PhoneLine> getAll () {
        return phoneLineService.getAll();
    }

    @GetMapping("/{id}")
    public Optional <PhoneLine> getById (@PathVariable final Integer id) {
        try {
            return phoneLineService.getById(id);
        } catch (PhoneDoNotExistsException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public int deleteById (@PathVariable final Integer id){
        try {
            phoneLineService.disableById(id);
        } catch (PhoneDoNotExistsException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
