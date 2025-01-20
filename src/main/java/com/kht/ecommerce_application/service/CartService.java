package com.kht.ecommerce_application.service;


import com.kht.ecommerce_application.dto.Cart;
import com.kht.ecommerce_application.dto.User;

import java.util.List;

public interface CartService {
   List <Cart> getCartByUserId(int userId);
}
