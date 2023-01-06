package com.example.twodatabases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.twodatabases.model.User;
import com.example.twodatabases.model.dto.UserDTO;
import com.example.twodatabases.repository.UserRepository;
import com.example.twodatabases.routing.ClientDatabaseContextHolder;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> createUser(UserDTO dto) {
        ClientDatabaseContextHolder.set(dto.getClientDatabase());
        User user = new User(dto);
        try {
            user = userRepository.saveAndFlush(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } finally {
            ClientDatabaseContextHolder.clear();
        }
    }

}
