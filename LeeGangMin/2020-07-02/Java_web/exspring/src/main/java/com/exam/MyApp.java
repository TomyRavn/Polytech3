package com.exam;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//등록할 때는 Component 어노테이션 태그를 쓴다.
@Component("ma")	//ma라는 이름으로 스프링에 등록 //원칙적으로는 (value = "ma")라고 써야함, 하지만 생략가능 
//이름을 생략하면, 클래스명의 첫글자만 소문자로 변경한 이름으로 등록
public class MyApp {
	
//	스프링에 등록된 객체를 이 속성에 주입(저장)하기 위해서는
//	@Autowired : 타입 기준 검색(타입이 일치하는 것이 2개 이상 있을 시 이름으로 검색)
//	@Inject	: 타입 기준 검색(타입이 일치하는 것이 2개 이상 있을 시 이름으로 검색)
//	@Resource : 이름 기준 검색(이름이 일치하는 것이 없을 시 타입으로 검색)
//	3개 중 하나를 써야함
	
	@Resource(name = "msen")	//스프링에 msen이라는 이름으로 등록된 객체를 이 변수에 주입(저장)
	private MyService myService;
	
	public void sayHello() {
		System.out.println( myService.getHelloMsg() );
	}
	
	public void sayBye() {
		System.out.println( myService.getByeMsg() );
	}

	
	////////////////////////= getter/setter =////////////////////////
	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
}