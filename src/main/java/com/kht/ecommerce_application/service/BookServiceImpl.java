package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Book;
import com.kht.ecommerce_application.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;


    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }
}
