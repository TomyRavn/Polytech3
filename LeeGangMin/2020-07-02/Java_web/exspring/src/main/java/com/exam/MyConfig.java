package com.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration			//스프링 설정파일 역할을 하는 클래스임을 표시
public class MyConfig {
	
	@Bean(name = "ma")	//이 메서드에서 반환하는 객체를 ma 라는 이름으로 스프링에 등록
	public MyApp ma() {
		MyApp myApp = new MyApp();
		myApp.setMyService(msen());
		return myApp;
	}
	
	@Bean				//이름을 생략하면 메서드 이름으로 스프링에 등록
	public MyService msen() {
		return new MyServiceEn();
	}
	
	@Bean
	public MyService msko() {
		return new MyServiceKo();
	}
	
}