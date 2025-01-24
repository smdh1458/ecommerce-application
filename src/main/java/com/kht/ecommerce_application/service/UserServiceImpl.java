package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.User;
import com.kht.ecommerce_application.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    // SecurityConfig 내부에 @Bean 태그로 설정한 BCRypto 호출해서 비밀번호 암호화 설정
    @Autowired //다른곳에서 작성된 속성이나 객체파일을 호출하기
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }


    @Override
    public void insertUser(User user){
        // 저장할 때 비밀번호만 암호화 처리해서 저장!
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userMapper.insertUser(user);
        //DB에서 가져온 값을 return 해서 반환할 필요 X
        // DB에 저장을 하는 것이지 데이터베이스에서 꺼내오는 것이 아니기 때문에
        // return 을 사용하지 않고 void 사용
    }

    @Override
    public Boolean existByEmail(String email) {
       return userMapper.existByEmail(email) > 0;
    }

    @Override
    public User getUserId(int id) {
        return userMapper.getUserId(id);
    }
}
