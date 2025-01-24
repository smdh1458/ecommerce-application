package com.kht.ecommerce_application.controller;

import com.kht.ecommerce_application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    // 장바구니 페이지
    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    //유저 장바구니 페이지
    @GetMapping("/cart{userId}")
    public String getCartByUserId(@PathVariable("userId") int id) {
        return "cart";
    }

    // 회원가입 페이지 볼 수 있게 회원가입.html 불러오기
    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/products/insert")
    public String insertProduct() {
        return "insertProduct";
    }



    @GetMapping("/product/")
    public String getProductById(@RequestParam("id") int id) {
        System.out.println("product id : " + id);
        return "product_detail";
    }

    @GetMapping("/user/")
    public String getUserById(@RequestParam("id")int id) {
        System.out.println("id:"+id);
        return "user_detail";
    }

    //수정하기 RequestParam 은 url 작성 X
    @GetMapping("/update/product")
    public String updateProduct(@RequestParam("id") int id) {
        return "updateProduct";
    }
}