package com.microservices.micro.responses;

import java.util.List;

import com.microservices.micro.models.Role;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class UserResponse {
    

    private long id;
   private List<Role> roles;
   private String name;
}
