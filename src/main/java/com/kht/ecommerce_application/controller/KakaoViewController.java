package com.kht.ecommerce_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 카카오톡 로그인 버튼 회원가입 html 이 보이는 viewController
@Controller
public class KakaoViewController {

    @GetMapping("/kakaoLogin")
    public String kakaoLogin() {
        return "kakaoLogin";
    }


    // signup or kakaoSignUp 상관없이 500 parameter -lang 오류
    // redirect 전달받을 때 ? 키=값 전달
    // 전달할 때 요청받은 requestParam 값이 존재하지 않으면 500 에러 발생
    @GetMapping("/signup")
    public String kakaoSignUp(@RequestParam("nickname")String nickname, @RequestParam("email")String email, Model model) {

        model.addAttribute("nickname", nickname);
        model.addAttribute("email", email);
        System.out.println(email);
        return "kakaoSignUp";
    }
}
