package com.kht.ecommerce_application.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/*
* url 주소값을 작성할 때
* ? 물음표가 들어가는 파라미터는 맨 마지막에 작성
*   /           /           /           ?       = 올바른 예
*   /           ?           /           /       = 잘못된 예
*
*  parameter 중간에 위치한 값을 찾지 못하는 경우가 많음
*
* !!!!!!!!! ? 가 들어가는 주소값은 ? 를 맨 마지막에 작성!!!!!
*
* */

@Controller
public class ViewBookController {
    /*
    * View - html 주소
    * html 파일을 바라보는 주소와
    * url 명칭 보통 동일하게 작성
    * 예외) 수정 / 상세보기 / 검색 일치하지 않을 수 있음
    *
    *
    * Api - JSON 데이터 주소
    * html 파일명과 api 주소와 다르게 작성
    *
    *
    *
    * */

    @GetMapping("/books")
    //@GetMapping(value = "/books", params = {})
    public String bookPage() {
        return "books";
    }

    //html 특정 파일
    //@GetMapping("/books/detail") //1.books/deatil?id =아이디 값  // 2.params ="id" 추가
    //@GetMapping(value = "/books", params = "id") // 2.params ="id" 추가
    /*
    * Mapping  = 특정 주소 값으로 기능이나 전달하고자 하는 행위를 감싸서 한 번에 전달
    * GET = DB에서 가져온 값을 전달할 것인가
    * POST = 저장할 것인가
    * PUT = 수정할 것인가
    * DELETE = 삭제할 것인가
    *
    * 특정 행위를 주고받고 전달하는 위치 = api = url = 주소값
    *
    * @Mapping (value = "url 명칭 / api 명칭" , 주소값 뒤나 중간에 사용할 파라미터가 존재하는가 ? 기본값 = 존재 X)
    * */
    @GetMapping(value = "/books", params = "id")
    public String getBookById(@RequestParam("id") int id) {
        return "book-detail";
    }

    // books/update?id= 설정  BEST!
    @GetMapping("/books/update")
    public String editBook(@RequestParam("id") int id) {
        return "book-edit";
    }
}
