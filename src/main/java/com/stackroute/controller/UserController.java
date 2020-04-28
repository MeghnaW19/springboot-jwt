package com.stackroute.controller;

import java.util.Map;

import com.stackroute.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.domain.User;
import com.stackroute.config.JWTTokenGenerator;
import com.stackroute.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;

    ResponseEntity<?> response;


    @PostMapping("user")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            response = new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if (user.getId() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Id and Password Empty");
            }
            User userDetails = userService.findByIdAndPassword(user.getId(), user.getPassword());
            if (userDetails == null) {
                throw new UserNotFoundException("Id and Password not found");
            }
            if (!(user.getPassword().equals(userDetails.getPassword()))) {
                throw new UserNotFoundException("Id and Password invalid");
            }
            response = new ResponseEntity<Map<String, String>>(jwtTokenGenerator.generateToken(userDetails),
                    HttpStatus.OK);
        } catch (UserNotFoundException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return response;
    }
}
