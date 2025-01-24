package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Product;
import com.kht.ecommerce_application.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productMapper.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }
}
