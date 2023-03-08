package com.microservices.micro.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.micro.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>  {
    
}
