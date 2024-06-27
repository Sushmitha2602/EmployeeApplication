package com.app.gloesports.service;

import com.app.gloesports.dto.UserDto;

/*
    make this into a service layer for User entity
    and implement the methods from UserService interface.
 */

public interface UserService {
    // Add a user
    UserDto addUser(UserDto userDTO);
    // Get a user by userId
    UserDto getUserById(Long userId);



}
