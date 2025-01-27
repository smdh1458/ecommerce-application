package com.kht.ecommerce_application.controller;

import com.kht.ecommerce_application.dto.Book;
import com.kht.ecommerce_application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api") //모든 url 앞에 /api url 자동 추가
@RestController
public class ApiBookController {
    // jquery ajax 를 활용해서 html 데이터를 주고 받는 json형식으로 전송
    @Autowired
    BookService bookService;

    // books로 GET 요청을 받아 책 목록 데이터를 반환
    @GetMapping("/bookList")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}/update")
    public int update(@PathVariable int id,
                       @RequestPart("title") String title,
                       @RequestPart("author") String author,
                       @RequestPart("genre") String genre,
                       @RequestPart("file") MultipartFile imagePath) {
        // @RequestBody -> RequestParam @MultipartFile file
        System.out.println("=======================controller 출력 ========================");
        System.out.println("title: "+title);
        System.out.println(author);
        System.out.println(genre);
        System.out.println(imagePath);

        return bookService.updateById(id, title, author, genre, imagePath);
        //return 책 정보 수정 서비스 연결;
    }
// /api/delete/${bookId}
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) {
        return bookService.deleteById(id);
    }
}
