package com.kht.ecommerce_application.controller;

import com.kht.ecommerce_application.dto.Product;
import com.kht.ecommerce_application.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//view -> html 파일 바라보기
//rest -> back-end가 DB에서 가져온 데이터를 url 주소값으로 전달만 하는 상태
@RestController
@RequestMapping("/api")
public class UDController {
    @Autowired
    ProductServiceImpl productService;

    //제품 업데이트
    //html 파일에서 전달받은 업데이트 상태 내용을 DB에 수정하기
    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct(product);
    }
}
