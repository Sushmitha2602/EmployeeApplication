package com.app.gloesports.controller;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// It is a controller class that handles the equipment related requests
@RestController
@RequestMapping("/api/users")
public class EquipmentController
{
    @Autowired
    private EquipmentService equipmentService;
    // Add equipment to a user
    @PostMapping("/{userId}/equipment")
    public ResponseEntity<EquipmentDto> addEquipmentToUser(@Valid @RequestBody EquipmentDto equipmentDto , @PathVariable("userId") Long userId)
    {

        return new ResponseEntity<>(equipmentService.addEquipmentToUser( equipmentDto , userId), HttpStatus.CREATED);
    }
    // Get equipment by equipmentId
    @GetMapping("/{userId}/equipment/{equipmentId}")
    public ResponseEntity<EquipmentDto> getEquipment(@PathVariable("userId") Long userID,@PathVariable("equipmentId") Long equipmentId)
    {
        return new ResponseEntity<>(equipmentService.getEquipmentById(userID, equipmentId),HttpStatus.OK);
    }
    // Delete equipment from a User by equipmentId
    @DeleteMapping("/{userId}/equipment/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(
            @PathVariable("userId") Long userId,
            @PathVariable("equipmentId") Long equipmentId
    ) {
        equipmentService.deleteEquipmentById(userId, equipmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}