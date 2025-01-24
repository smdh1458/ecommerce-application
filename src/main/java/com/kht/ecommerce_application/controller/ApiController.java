package com.kht.ecommerce_application.controller;

import com.kht.ecommerce_application.dto.Cart;
import com.kht.ecommerce_application.dto.Product;
import com.kht.ecommerce_application.dto.User;
import com.kht.ecommerce_application.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
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
   public List<Cart> getCart(@RequestParam("userId") int userId) {
       return cartService.getCartByUserId(userId);
   }
    /*
       HTTP Status 500 - Internal Server Error 서버에서 생각지 못한 문제 발생
    */

    /*
    Param = 파라미터 = 매개변수
    * @RequestParam 부분적으로 저장할 때 사용
    * @RequestBody  전체적으로 저장할 때 사용
    * */
    @PostMapping("/api/join")
    public void join(@RequestBody User user) {
        log.info("join user: {}", user);
        userService.insertUser(user);
    }

    @GetMapping("/api/existEmail")
    public boolean existByEmail(@RequestParam("email") String email) {
        return userService.existByEmail(email); //결과를 html true false로 전달
    }

    @PostMapping("/api/products/insert")
    public void insertProduct(@RequestBody Product product) {
        log.info("insert product: {}", product);
        productService.insertProduct(product);
    }

    @GetMapping("/api/user/{userId}")
    public User getUserId(@PathVariable("userId") int id) {
        return userService.getUserId(id);
    }

    @GetMapping("/api/product/{id}")
    public Product getProductId(@PathVariable("id") int id) {
        return productService.getProductById(id);
        // DB에서 가져온 데이터를 front-end로 전달
    }


}
