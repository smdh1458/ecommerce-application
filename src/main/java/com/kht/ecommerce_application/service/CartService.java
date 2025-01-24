package com.kht.ecommerce_application.service;


import com.kht.ecommerce_application.dto.Cart;
import com.kht.ecommerce_application.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
   List <Cart> getCartByUserId(int userId);
}
