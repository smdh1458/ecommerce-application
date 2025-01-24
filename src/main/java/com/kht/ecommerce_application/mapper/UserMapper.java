package com.kht.ecommerce_application.mapper;


import com.kht.ecommerce_application.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // DB에서 데이터를 가져올 때 DTO 사용
    // 사용자 조회
    List<User> getAllUser();

    //사용자 저장 insert 1개일경우 나 갯수 상관이 없다면 void 갯수가 중요하다면 int로 몇개 넣었는지 반환
    void insertUser(User user);

    // 이메일 존재 유무 확인
    int existByEmail(String email);

    //id로 유저정보 찾기
    User getUserId(int id);

    //수정하기 수정을 1가지만 진행할 경우 void로 작성할 수 있음
    // 갯수가 여러개일 경우 int 사용하는 것이 좋음
    void editUser(User user);

    // int GET = 몇 개 찾았는지
    // int editUser(User user); -> 예시

}
