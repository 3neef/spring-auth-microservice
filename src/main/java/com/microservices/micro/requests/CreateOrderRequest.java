package com.microservices.micro.requests;

import java.math.BigDecimal;

import com.microservices.micro.models.OrderStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString

public class CreateOrderRequest {
    
    
    private UserRequest user;
@Min(500)
    private BigDecimal amount;

    @Valid
    @NotNull
    private CreateItemRequest item;

    private OrderStatus status=OrderStatus.Draft;
}
