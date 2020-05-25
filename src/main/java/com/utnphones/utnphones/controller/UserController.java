package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.exception.user.UserAlreadyExistsException;
import com.utnphones.utnphones.exception.user.UserDoNotExistsException;
import com.utnphones.utnphones.exception.user.UsernameTakenException;
import com.utnphones.utnphones.model.Call;
import com.utnphones.utnphones.model.User;
import com.utnphones.utnphones.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final CallController callController;
    private final PhoneLineController phoneLineController;

    @Autowired
    public UserController(UserService userService, CallController callController, PhoneLineController phoneLineController) {
        this.userService = userService;
        this.callController = callController;
        this.phoneLineController = phoneLineController;
    }

    @PostMapping("/")
    public void addUser (@RequestBody final User user) {
        try {
            userService.add(user);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        } catch (UsernameTakenException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public List <User> getAll () {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById (@PathVariable final Integer id) throws UserDoNotExistsException {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable final Integer id) throws UserDoNotExistsException {
        return userService.disableById(id);
    }

//    @GetMapping("{id}/calls")
//    public List <Call> getCallsByUserId (@PathVariable final Integer id) {
//        return callController.getCallsByUserId(id);
//    }

//    @GetMapping("/{id}/lines")
//    public List <Line> getLinesByUserId (@PathVariable final Integer id) {
//        return phoneLineController.getLinesByUserId(id);
//    }


}
