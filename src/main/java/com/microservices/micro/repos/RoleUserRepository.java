package com.microservices.micro.repos;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.microservices.micro.models.RoleUser;
// @Repository
// @EnableJpaRepositories
public interface RoleUserRepository extends JpaRepository<RoleUser,Long>{
    
}
