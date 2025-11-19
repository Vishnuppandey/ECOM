package com.ecom.dto;

import com.ecom.model.Category;

public class ProductUpdate {

    private String productname;
    private double productprice;
    private Category productcategory;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public Category getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(Category productcategory) {
        this.productcategory = productcategory;
    }
}
