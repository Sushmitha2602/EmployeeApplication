package com.app.gloesports.repository;

import com.app.gloesports.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a equipment repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {

}
