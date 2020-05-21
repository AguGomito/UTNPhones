package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.model.Call;
import com.utnphones.utnphones.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
public class CallController {

    private final CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    @PostMapping("/")
    public void addCall (@RequestBody Call call) {
        callService.addCall(call);
    }

    @GetMapping("/")
    public List <Call> getAll () {
        return callService.getAll();
    }
}
