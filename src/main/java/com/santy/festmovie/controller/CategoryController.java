package com.santy.festmovie.controller;

import com.santy.festmovie.domain.Category;
import com.santy.festmovie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("category")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);

    }
}
