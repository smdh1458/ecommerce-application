package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    void insertProduct(Product product);

    Product getProductById(int id);

    void updateProduct(Product product);
}
