package com.kht.ecommerce_application.mapper;

import com.kht.ecommerce_application.dto.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getAllBooks();

    Book getBookById(int id);
}
