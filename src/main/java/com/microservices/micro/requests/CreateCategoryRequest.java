package com.microservices.micro.requests;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter  @AllArgsConstructor @NoArgsConstructor @Getter

public class CreateCategoryRequest {
    
    @NotNull
    private String name;
    @NotNull
    private String  status;
    @NotNull
    private String type;
}
