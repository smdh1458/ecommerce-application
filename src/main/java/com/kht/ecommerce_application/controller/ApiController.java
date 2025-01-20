package com.kht.ecommerce_application.controller;

import com.kht.ecommerce_application.dto.Cart;
import com.kht.ecommerce_application.dto.Product;
import com.kht.ecommerce_application.dto.User;
import com.kht.ecommerce_application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CartServiceImpl cartService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getAllUser();
    }


    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }


   //특정 사용자의 장바구니 API
   //http://localhost:8080/api/cart?userId=1
   @GetMapping("/api/carts")
    public List <Cart> getCart(@RequestParam("userId") int userId) {
        return cartService.getCartByUserId(userId);
    }
    /*
       HTTP Status 500 - Internal Server Error 서버에서 생각지 못한 문제 발생
    */
    @GetMapping("/cart{userId}")
    public String getCartByUserId(@PathVariable("userId") int id) {
        return "cart";
    }
}
