package com.microservices.micro.requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class CreateItemRequest {
    @Min(100)
    @Max(5000)
    private BigDecimal price;
    private String name;
}
