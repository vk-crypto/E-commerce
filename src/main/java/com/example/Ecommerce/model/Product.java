package com.example.Ecommerce.model;

import lombok.Data;

@Data
public class Product {

    Integer Id;
    String productName;
    String brandName;
    float price;

    public Product(int id, String productName, String brandName, float price) {
        this.Id=id;
        this.productName=productName;
        this.brandName=brandName;
        this.price=price;
    }
}
