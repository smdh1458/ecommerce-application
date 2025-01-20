package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Cart;
import com.kht.ecommerce_application.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCartByUserId(int userId) {
        return cartMapper.getCartByUserId(userId);
    }
}
