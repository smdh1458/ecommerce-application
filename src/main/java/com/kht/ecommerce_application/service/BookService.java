package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    /*
    @Autowired = 다른 파일이나 다른 파일안에 작성된 기능을 가져와서 사용

    interface는 특정 기능을 상세하거 어떠한 동작으로 작동하라는 세부 기능 설정을
    해주지 않기 때문에 @Autowired 를 작성할 필요가 없음 XXX
    @Autowired
    private BookMapper bookmapper;
     */

    List<Book> getAllBooks();

    Book getBookById(int id);

    int updateById(int id, String title, String author, String genre, MultipartFile file);

    int deleteById(int id);
}
