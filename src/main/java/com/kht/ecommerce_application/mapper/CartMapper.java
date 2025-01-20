package com.kht.ecommerce_application.mapper;

import com.kht.ecommerce_application.dto.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List <Cart> getCartByUserId(int userId);
}
