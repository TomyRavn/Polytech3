package com.exam;

import org.springframework.stereotype.Component;

//@Component("msen")		//주석처리하여 스트링에 등록하지 않을 시 MyApp에서 Resource name을 작성하지 않아도 msko 하나 밖에 없기 때문에 msko를 자동 인식
//@Component("myService")
public class MyServiceEn implements MyService{

	@Override
	public String getHelloMsg() {
		return "Hello!";
	}

	@Override
	public String getByeMsg() {
		return "Good-Bye!";
	}

}