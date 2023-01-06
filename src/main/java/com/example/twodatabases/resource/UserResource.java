package com.example.twodatabases.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twodatabases.model.dto.UserDTO;
import com.example.twodatabases.service.UserService;

@RestController
@RequestMapping(value = "/multidatabase-api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserResource {
    
    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO dto) {
        return userService.createUser(dto);
    } 

}
