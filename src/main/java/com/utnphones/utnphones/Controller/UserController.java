package com.utnphones.utnphones.Controller;

import com.utnphones.utnphones.Model.User;
import com.utnphones.utnphones.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public void addUser (@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/")
    public List<User> getAll () {
        return userService.getAll();
    }
}
