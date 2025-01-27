package com.kht.ecommerce_application.mapper;

import com.kht.ecommerce_application.dto.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

//mapper.xml에 작성된 sql문을
// 아이디 명칭으로 가져와서 가져온 sql문을 사용 대기중인 상태
@Mapper
public interface BookMapper {
    // 책 목록 모두 조회 = getAllBooks
    // *** 목록이나 리스트와 같은 형태로
    // 2개 이상을 조회할 때는 List<DTO파일명>을 맨 앞에 작성

    //@Select("select * from book") 이건 회사마다 방식이 다름
    List<Book> getAllBooks(); //select * from Book sql 문이 들어있는 상태

    //특정 정보 조회
    Book getBookById(int id);

    //수정 void                   int  -> 수정한 행의 수

    int updateById(int id, String title, String author, String genre, String imagePath);

    int deleteById(int id);
}
