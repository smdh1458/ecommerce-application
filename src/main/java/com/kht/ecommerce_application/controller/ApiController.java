package com.kht.ecommerce_application.controller;

import com.kht.ecommerce_application.dto.Book;
import com.kht.ecommerce_application.dto.Cart;
import com.kht.ecommerce_application.dto.Product;
import com.kht.ecommerce_application.dto.User;
import com.kht.ecommerce_application.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ApiController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private BookServiceImpl bookService;

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

    //id로 유저 정보 가져오기
    @GetMapping("/api/user/{userId}")
    public User getUserId(@PathVariable("userId") int id) {
        return userService.getUserId(id);
    }

    //id로 유저 정보 사용자 수정하기
    @PutMapping("/api/user/edit/{userId}") // @PathVariable = 특정사용자 데이터를 주고받는 장소  @Request = 데이터를 통째로 전달받거나, 일부분만 전달받아서 사용하거나 전달
    public void editUser(@PathVariable("userId") int userId, @RequestBody User user) {
        user.setId(userId); //수정하기 주소에 존재하는 유저 아이디를 가져와서 User DTO에 넣어주고, mapper.xml where id에서 넣어준 id를 사용할 수 있음
        userService.editUser(user);
    }


    //id로 제품정보 가져오기
    @GetMapping("/api/product/{id}")
    public Product getProductId(@PathVariable("id") int id) {
        return productService.getProductById(id);
        // DB에서 가져온 데이터를 front-end로 전달
    }

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }


}
