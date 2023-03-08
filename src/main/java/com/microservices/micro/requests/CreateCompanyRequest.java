package com.microservices.micro.requests;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter  @AllArgsConstructor @NoArgsConstructor @Getter

public class CreateCompanyRequest {
    
    @NotNull
    private String name;
   

}
