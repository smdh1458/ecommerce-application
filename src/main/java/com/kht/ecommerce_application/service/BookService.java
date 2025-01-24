package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);
}
