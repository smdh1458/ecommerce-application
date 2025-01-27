package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.Book;
import com.kht.ecommerce_application.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

// 실질적으로 서비스 기능을 하고있는 파일은
// Impl 구현 목록을 받아 상세기능을 작성한 class 파일이기 때문에
// Impl 붙은 파일에 @Service 어노테이션 설정
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    //세부 기능을 구현하고, 특정 sql문으로 기능 작동을 수행하기 위해
    // @Autowired 를 사용

    @Autowired
    private BookMapper bookMapper;

    //config.properties 에 작성한 경로 가져오기
    @Value("${upload-img}")
    private String uploadImg;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public int updateById(int id, String title, String author, String genre, MultipartFile imagePath) {
        System.out.println("=======================service 출력 ========================");
        System.out.println(title);
        System.out.println(author);
        System.out.println(genre);
        System.out.println(imagePath);
        try {
            String imgPath = imagePath.getOriginalFilename();
            System.out.println("파일명: "+ imgPath);
            File file = new File(uploadImg, imgPath);
            System.out.println("수정된파일명: "+ file);
            imagePath.transferTo(file);


            Book book = new Book();
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            //진짜로 저장된 이미지 장소를 숨기고 사용자들에게는 images 경로로 보여주게 끔 설정
            book.setImagePath("/uploaded/" + imgPath); // 이미지는 파일에서 이미지이름만 추출한다음 글자형태로 db저장
            System.out.println(book);
            //이미지 이름만 get 가져와서 string 위치 + 이미지 이름만 db저장

            /*
            * book 변수이름에 id, title, author, genre, imgPath 모두 들어잇음
            * 1번 return bookMapper.updateById(id, title, author, genre, imgPath);
            * 2번 return bookMapper.updateById(book);
            * 1,2 번 둘 다 동일한 코드
            *
            * */
            return bookMapper.updateById(id, title, author, genre, imgPath);
            //return bookMapper.updateById(book);
        } catch (IOException e) {
            //개발자가 컴퓨터 작업에 문제가 있을 때 문제를 확인하는 멘트
            System.out.println("이미지 저장 오류: " + e.getMessage());
            return 0;
        }

    }

    @Override
    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }
/*
    @Override
    public int updateById(Book book) {
        // all data
        // multipartfile get url -> String fileName = get()
        // set imgPath save
        return bookMapper.updateById(book);
    }

 */

}
