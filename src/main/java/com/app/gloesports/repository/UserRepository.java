package com.app.gloesports.repository;

import com.app.gloesports.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a user repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
