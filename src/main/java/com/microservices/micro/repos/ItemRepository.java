package com.microservices.micro.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.microservices.micro.models.Item;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item,Long>{
    
}
