package com.app.gloesports.service.impl;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.entity.Equipment;
import com.app.gloesports.entity.User;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.EquipmentRepository;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.EquipmentService;
import com.app.gloesports.utils.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// make this into a service layer for Equipment entity
@Service
public class EquipmentServiceImpl implements EquipmentService {
   @Autowired
    private UserRepository userRepository;
   @Autowired
    private EquipmentRepository equipmentRepository;


    @Override
    public EquipmentDto addEquipmentToUser(EquipmentDto equipmentDto, Long userId)
    {

//checking if user is present or not
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user","userId",userId)
        );

        //saving this dto object to equipment
        Equipment savedequ = equipmentRepository.save(Mapper.mapToEquipmentEntity(equipmentDto));
        // add equipment to user equipment list
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(savedequ);
        //setting this equipment to a particular user
        user.setEquipment(equipmentList);
        //add user object to equipment
        savedequ.setUser(user);

        Equipment result = equipmentRepository.save(savedequ);
        return Mapper.mapToEquipmentDto(result);
    }
    @Override
    public EquipmentDto getEquipmentById(Long userId, Long equipmentId)
    {
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user","userId",userId)
        );
        Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(
                ()-> new ResourceNotFoundException("equipment","equipmentId",equipmentId)
        );
        return Mapper.mapToEquipmentDto(equipment);
    }

    @Override
    public EquipmentDto deleteEquipmentById(Long equipmentId, Long userId)
    {
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user","userId",userId)
        );
        Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(
                ()-> new ResourceNotFoundException("equipment","equipmentId",equipmentId)
        );
        equipmentRepository.delete(equipment);
        // return null;
        return null;
    }

}

