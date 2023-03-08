package com.microservices.micro.models;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
private long id;

    private String name;
    private BigDecimal price; 

}
