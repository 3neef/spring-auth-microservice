package com.microservices.micro.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.microservices.micro.models.User;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);
    Page<User> findByNameLike(String name,Pageable pageable);
    List<User> findByNameAndPassword(String name,String password);
    List<User> findByNameLike(String name);
}
