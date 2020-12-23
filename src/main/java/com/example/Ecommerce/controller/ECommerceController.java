package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.services.ECommerceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ECommerceController {

    @Autowired
    private ECommerceServices eCommerceServices;


    @GetMapping("products")
    public List<Product> getProducts() {
        return eCommerceServices.getProducts();
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) throws Exception {
        Product p = eCommerceServices.getProduct(id);
        if (p != null) {
            return p;
        } else
            throw new Exception("product Id not available");
    }

    @GetMapping("products/name/{name}")
    public List getProductByName(@PathVariable("name") String name) throws Exception {

        if (eCommerceServices.getProductByName(name).stream().count() > 0) {
            return eCommerceServices.getProductByName(name);
        } else
            throw new Exception("Product is not available");

    }

    @GetMapping("products/brand/{brandName}")
    public List getProductByBrand(@PathVariable("brandName") String brandName) throws Exception {

        if (eCommerceServices.getProductByBrand(brandName).stream().count() > 0) {
            return eCommerceServices.getProductByBrand(brandName);
        } else
            throw new Exception("Brand is not available");

    }
}
