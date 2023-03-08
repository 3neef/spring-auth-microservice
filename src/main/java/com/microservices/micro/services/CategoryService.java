package com.microservices.micro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.micro.models.Category;
import com.microservices.micro.repos.CategoryRepository;
import com.microservices.micro.requests.CreateCategoryRequest;


@Service
public class CategoryService {
    @Autowired

    private CategoryRepository categoryRepository;
    

    public Category create(CreateCategoryRequest categoryRequest){

         Category category = new Category(0,categoryRequest.getName(),categoryRequest.getStatus(),categoryRequest.getType());// remember sorted in collection is important  remember that
         Category result = categoryRepository.save(category);

        return result;

        
    }
}
