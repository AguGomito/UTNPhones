package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.Call;
import com.utnphones.utnphones.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService {

    private final CallRepository callRepository;

    @Autowired
    public CallService(CallRepository callInterface) {
        this.callRepository = callInterface;
    }

    public void addCall (Call call) {
        callRepository.save(call);
    }

    public List <Call> getAll () {
        return callRepository.findAll();
    }
}
