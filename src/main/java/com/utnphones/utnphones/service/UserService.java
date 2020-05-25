package com.utnphones.utnphones.service;

import com.utnphones.utnphones.exception.user.UserAlreadyExistsException;
import com.utnphones.utnphones.exception.user.UserDoNotExistsException;
import com.utnphones.utnphones.exception.user.UsernameTakenException;
import com.utnphones.utnphones.model.User;
import com.utnphones.utnphones.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add (User newUser) throws UserAlreadyExistsException, UsernameTakenException {
        Optional <User> user = userRepository.findByDni (newUser.getDni());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException("The user already exists");
        }
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            throw new UsernameTakenException("The username is already in use");
        }
        userRepository.save(newUser);
    }

    public List<User> getAll () {
        return userRepository.findAll();
    }

    public Optional <User> getById (Integer id) throws UserDoNotExistsException {
        Optional <User> user = userRepository.findById(id);
        if (!(user.isPresent())) {
            throw new UserDoNotExistsException("The user does not exists");
        }
        return user;
    }

    public int disableById (Integer id) throws UserDoNotExistsException {
        Optional <User> user = userRepository.findById(id);
        if(!(user.isPresent())) {
            throw new UserDoNotExistsException("User does not exists");
        }
        return userRepository.disableById(id);
    }

    public User updateById (Integer id, User updatedUser) throws UserDoNotExistsException, UsernameTakenException {
        Optional <User> user = userRepository.findById(id);
        if (!(user.isPresent())) {
            throw new UserDoNotExistsException("User does not exists");
        }
        if (userRepository.findByUsername(updatedUser.getUsername())) {
            throw new UsernameTakenException("The username is already in use");
        }
        user.get().setName(updatedUser.getName());
        user.get().setLastname(updatedUser.getLastname());
        user.get().setDni(updatedUser.getDni());
        user.get().setUsername(updatedUser.getUsername());
        user.get().setPassword(updatedUser.getPassword());
        user.get().setCity(updatedUser.getCity());
        return userRepository.save(user.get());
    }
}
