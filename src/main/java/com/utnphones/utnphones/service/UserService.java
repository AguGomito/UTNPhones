package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.User;
import com.utnphones.utnphones.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser (User user) {
        userRepository.save(user);
    }

    public List<User> getAll () {
        return userRepository.findAll();
    }

}
