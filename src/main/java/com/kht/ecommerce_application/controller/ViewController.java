package com.kht.ecommerce_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 사용자 목록 페이지
    @GetMapping("/")
    public String usersPage() {
        return "index";
    }

    // 상품 목록 페이지
    @GetMapping("/products")
    public String productsPage() {
        return "products";
    }

    /*
    // 장바구니 페이지
    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }
     */
}