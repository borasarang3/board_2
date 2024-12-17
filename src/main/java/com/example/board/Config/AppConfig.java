package com.example.board.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정용 클래스
//기능 및 변수등을 예약
@Configuration
public class AppConfig {
    @Bean //스프링부트 시스템에 등록
    public ModelMapper modelMapper() {
        return new ModelMapper();
    } //ModelMapper로 선언하면 자동으로 new ModelMapper() 적용
}
