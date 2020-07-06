package com.exam;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ma") //"ma"라는 이름으로 스프링에 등록
//이름을 생락하면, 클래스명의 첫글자만 소문자로 변경한 이름으로 등록
public class MyApp {
	//스프링에 등록된 객체들 중 하나를 이 속성에 주입(저장)하기 위해서는 
	//@Autowired(타입우선),@Inject(타입우선),@Resource 중 하나를 사용
	//@Resource //(name = "msko") //스프링에 msen 이라는 이름으로 등록된 객체를 이 변수에 주입
	@Resource //(name = "msko") //스프링에 msen이라는 이름으로 등록된 객체를 이 변수에 주입(저장) 이름을 생략하면 변수이름으로 찾음
								//스프링에 등록된 객체들 중 이름이 일치하는 객체를 찾지 못하면 타입이 일치하는 객체를 주입 변수 ,메소드,생성자 모두 사용가능
	private MyService myService;
	
	public MyService getMyService() {
		return myService;
	}
	
	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
	public void sayHello() {
		System.out.println(myService.getHelloMsg());
	}
	public void sayBye() {
		System.out.println(myService.getByeMsg());
	}

}
