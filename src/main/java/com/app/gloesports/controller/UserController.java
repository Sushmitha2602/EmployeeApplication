package com.app.gloesports.controller;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// It is a controller class that handles the user related requests
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto){
        UserDto saved=userService.addUser(userDto);
        return new ResponseEntity<>( saved, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId)
    {
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }



    // Add a user

    //Get a user by userId

}
