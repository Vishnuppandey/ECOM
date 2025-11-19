package com.ecom.service;

import com.ecom.dto.ProductUpdate;
import com.ecom.exception.CategoryNotFoundException;
import com.ecom.exception.ProductNotFound;
import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.repo.CategoryRepository;
import com.ecom.repo.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private ProductRepository productrepo;
    private CategoryRepository categoryRepository;
    public ProductService(ProductRepository productrepo,CategoryRepository categoryRepository){
        this.productrepo=productrepo;
        this.categoryRepository=categoryRepository;
    }

    public Product createProduct(Product product){
        Long categoryId=product.getCategory().getId();
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->{
            throw new CategoryNotFoundException("category not found with this id : "+categoryId);
        });
        category.getProducts().add(product);
        return productrepo.save(product);
    }
    public Product updateProduct(Long id,ProductUpdate productupdate) throws ProductNotFound{
        Product product=productrepo.findById(id).orElseThrow(()->{
            throw new ProductNotFound("product not found with this id : "+id);
        });
        product.setProductname(productupdate.getProductname());
        product.setPrice(productupdate.getProductprice());
        product.setCategory(productupdate.getProductcategory());
        return product;
    }
    public void deleteProduct(Long id) throws ProductNotFound{
        Product product=productrepo.findById(id).orElseThrow(()->{
            throw new ProductNotFound("product not found with this id : "+id);
        });
        productrepo.deleteById(id);
    }

    public Product getProduct(Long id) throws ProductNotFound{
        Product product=productrepo.findById(id).orElseThrow(()->{
            throw new ProductNotFound("product not found with this id : "+id);
        });
        return product;
    }

}
