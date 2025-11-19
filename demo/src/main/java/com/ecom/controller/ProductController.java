package com.ecom.controller;

import com.ecom.dto.ProductUpdate;
import com.ecom.model.Product;
import com.ecom.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
       return productService.createProduct(product);
    }
    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }
    @PutMapping("/update/{id}")
    public Product updateproduct(@PathVariable Long id,@RequestBody ProductUpdate update){
        return productService.updateProduct(id,update);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteproduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
