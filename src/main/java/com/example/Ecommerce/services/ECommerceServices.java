package com.example.Ecommerce.services;

import com.example.Ecommerce.model.Product;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ECommerceServices {

    private static final ArrayList<Product> productArrayList = new ArrayList<>();

    ECommerceServices() {
        productArrayList.add(new Product(1, "Note 9 Pro", "SAMSUNG", 12999.00f));
        productArrayList.add(new Product(2, "moto G 5", "MOTO", 21999.00f));
        productArrayList.add(new Product(3, "MacBook Pro", "APPLE", 289887.29f));
        productArrayList.add(new Product(4, "TV", "LG", 12331321.0872f));
    }

    public Product getProduct(Integer id) {
        Product p = productArrayList.get(id);
        return p;
    }

    public List<Product> getProducts() {

        return productArrayList;
    }

    public List getProductByName(String productName) {
        return productArrayList.stream().filter(x -> x.getProductName().equals(productName)).collect(Collectors.toList());
    }

    @Cacheable(value = "product-cache",key = "'productCache'+#brandName")
    public List getProductByBrand(String brandName) throws InterruptedException {
        Thread.sleep(1000);
        return productArrayList.stream().filter(x -> x.getBrandName().equals(brandName)).collect(Collectors.toList());
    }
}
