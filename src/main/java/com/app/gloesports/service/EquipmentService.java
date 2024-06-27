package com.app.gloesports.service;


import com.app.gloesports.dto.EquipmentDto;

/*
    make this into a service layer for Equipment entity
    and implement the methods from EquipmentService interface.
 */
public interface EquipmentService {
    // Add equipment to a user
    EquipmentDto addEquipmentToUser(EquipmentDto equipmentDto, Long userId);
    // Get equipment by equipmentId
    EquipmentDto getEquipmentById(Long userId, Long equipmentId);
    // Delete equipment from a User by equipmentId
    EquipmentDto deleteEquipmentById(Long equipmentId, Long userId);

}
