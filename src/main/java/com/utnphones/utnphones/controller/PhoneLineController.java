package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.model.PhoneLine;
import com.utnphones.utnphones.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneLine")
public class PhoneLineController {

    private PhoneLineService phoneLineService;

    @Autowired
    public PhoneLineController(PhoneLineService phoneLineService) {
        this.phoneLineService = phoneLineService;
    }

    @PostMapping("/")
    public void addPhoneLine (@RequestBody PhoneLine phoneLine) {
        phoneLineService.addPhoneLine(phoneLine);
    }

    @GetMapping("/")
    public List<PhoneLine> getAll () {
        return phoneLineService.getAll();
    }
}
