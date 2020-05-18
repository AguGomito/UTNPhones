package com.utnphones.utnphones.Service;

import com.utnphones.utnphones.Model.User;
import com.utnphones.utnphones.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser (User user) {
        userRepository.save(user);
    }

    public List<User> getAll () {
        return userRepository.findAll();
    }

}
