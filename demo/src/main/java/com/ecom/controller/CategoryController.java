package com.ecom.controller;

import com.ecom.dto.CategoryUpdate;
import com.ecom.model.Category;
import com.ecom.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id, CategoryUpdate category){
        return categoryService.updateCategory(id,category);
    }
    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
