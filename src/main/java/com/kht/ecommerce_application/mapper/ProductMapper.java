package com.kht.ecommerce_application.mapper;

import com.kht.ecommerce_application.dto.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProducts();

    void insertProduct(Product product);
}
