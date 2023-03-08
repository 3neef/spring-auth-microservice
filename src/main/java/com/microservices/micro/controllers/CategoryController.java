package com.microservices.micro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.micro.models.Category;
import com.microservices.micro.requests.CreateCategoryRequest;
import com.microservices.micro.responses.BasicResponse;
import com.microservices.micro.services.CategoryService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private  CategoryService categoryservices;

    @PostMapping(name = "/")
    public @ResponseBody ResponseEntity<?> insert(@RequestBody @Valid CreateCategoryRequest input) {
        Category category=categoryservices.create(input);//call function in services
        return new ResponseEntity<>(new BasicResponse("created successfully","000",category), HttpStatus.OK);
    }
}
