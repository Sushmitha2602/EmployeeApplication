package com.app.gloesports.service.impl;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.User;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.EquipmentService;
import com.app.gloesports.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a service layer for User entity
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private EquipmentService equipmentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private UserDto mapToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    // Map UserDto to User entity
    private User mapToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

    @Override
    public UserDto addUser(UserDto userDTO) {
        User user=userRepository.save(mapToEntity(userDTO));
        return mapToDto(user);
    }

    @Override
    public UserDto getUserById(Long userId)
    {
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user","id",userId)
        );
        return mapToDto(user);
    }
}
