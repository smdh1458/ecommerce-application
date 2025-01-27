package com.kht.ecommerce_application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {
    // config.properties 에 작성한 파일 저장 경로 설정
    @Value("${upload-img}")
    private String uploadPath;
    // 이미지를 처리할 때 1. static 폴더 아래 이미지
    //                    2. 업로드 폴더 위치 이미지 설정
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 이미지 위치가 여러 공간일 경우에는  각 위치별 페이크 위치를 사용해서 별칭 사용
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/uploaded/**").
                addResourceLocations("file:"+uploadPath+"/");
    }
}
