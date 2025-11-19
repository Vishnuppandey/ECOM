package com.ecom.service;

import com.ecom.dto.CategoryUpdate;
import com.ecom.exception.CategoryNotFoundException;
import com.ecom.model.Category;
import com.ecom.repo.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepo;
    public CategoryService(CategoryRepository categoryRepo){
        this.categoryRepo=categoryRepo;
    }

    public Category saveCategory(Category category){
         return categoryRepo.save(category);
    }

    public Category updateCategory(Long id, CategoryUpdate dto) throws CategoryNotFoundException {
        Category category=categoryRepo.findById(id).orElseThrow(()->{
            throw new CategoryNotFoundException("category not found with id : "+id);
        });
        category.setCategoryname(dto.getCategoryname());
        return category;
    }

    public void deleteCategory(Long id) throws CategoryNotFoundException {
       Category category=categoryRepo.findById(id).orElseThrow(()->{
           throw new CategoryNotFoundException("category not found with id : "+id);
       });
       categoryRepo.deleteById(id);
    }
    public Category getCategory(Long id){
        Category category=categoryRepo.findById(id).orElseThrow(()->{
            throw new CategoryNotFoundException("category not found with id : "+id);
        });
        return category;
    }

}
