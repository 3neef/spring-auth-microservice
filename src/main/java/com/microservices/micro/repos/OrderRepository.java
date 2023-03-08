package com.microservices.micro.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.microservices.micro.models.Order;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
