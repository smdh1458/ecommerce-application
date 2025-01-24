package com.kht.ecommerce_application.controller;


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

    //제품 추가
    @GetMapping("/products/insert")
    public String insertProduct() {
        return "insertProduct";
    }



    //제품 상세 페이지
    @GetMapping("/product/")
    public String getProductById(@RequestParam("id") int id) {
        System.out.println("product id : " + id);
        return "product_detail";
    }

    //유저 상세 페이지
    @GetMapping("/user/")
    public String getUserById(@RequestParam("id")int id) {
        System.out.println("id:"+id);
        return "user_detail";
    }

    //유저 정보 수정페이지 조회 user_edit.html
    @GetMapping("/user/edit")
    public String editUserById(@RequestParam("id") int id) {
        return "user_edit";
    }

    //수정하기 RequestParam 은 url 작성 X
    @GetMapping("/update/product")
    public String updateProduct(@RequestParam("id") int id) {
        return "updateProduct";
    }

    @GetMapping("/book")
    public String bookPage() {
        return "bookList";
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable("id") int id) {
        return "book-detail";
    }

}