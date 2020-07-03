package com.exam;

import org.springframework.stereotype.Component;

@Component("msko")
//@Component
//Myapp.java에서 resource가 msen일 때, 이 부분을 주석처리하면 인식됨
//myServiceKo로 등록됨
public class MyServiceKo implements MyService{

	@Override
	public String getHelloMsg() {
		return "안녕하세요!";
	}

	@Override
	public String getByeMsg() {
		return "안녕히 가세요!";
	}

}