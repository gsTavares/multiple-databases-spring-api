package com.example.twodatabases.model.dto;

import com.example.twodatabases.model.User;
import com.example.twodatabases.routing.enumerated.ClientDatabase;

public class UserDTO {
    
    private Long id;
    private String username;
    private String password;
    private ClientDatabase clientDatabase;
    
    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.clientDatabase = user.getClientDatabase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientDatabase getClientDatabase() {
        return clientDatabase;
    }

    public void setClientDatabase(ClientDatabase clientDatabase) {
        this.clientDatabase = clientDatabase;
    }
    

}