package com.microservices.micro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.micro.models.Role;
import com.microservices.micro.responses.BasicResponse;
import com.microservices.micro.services.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public @ResponseBody ResponseEntity<?>  create(@RequestBody @Valid Role role) {
        Role result=roleService.create(role);

        return new ResponseEntity<>(new BasicResponse("success","000",result), HttpStatus.OK);

    }
    
}
