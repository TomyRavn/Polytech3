package com.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//AOP : 관점 지향 프로그래밍 ; 코드를 원하는 위치에 삽입 또는 해제 시켜주는 기능

//스프링 = IOC/DI 와 AOP 기능을 지원하는 객체(Bean) [들을 담고 있는] 컨테이너 = ApplicationContext
// IOC : Inversion Of Control ; 제어 반전 //== DI : Dependency Injection ; 의존성 주입
// 객체를 생성해서 제어하던 것을 Spring이 제어해준다    //   써놓으면 Spring이 만들어서 넣어준다.

public class AppMain {
	
	public static void main(String[] args) {

//		MyApp myApp = new MyApp();
		
		//1.
//		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("스프링설정파일");
		
		//2.
		//클래스 path에 있는 "/com/exam/context.xml" 설정파일에 적혀있는대로
		//객체들을 생성하여 ApplicationContext를 생성
		//ApplicationContext == 스프링 본체 == 객체들을 담고 있는 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/exam/context.xml");
		
		//3.
		//MyConfig 클래스에 자바로 작성한 설정 내용대로 스프링 객체 컨테이너를 생성
//		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		MyApp myApp = (MyApp) context.getBean("ma");	//스프링에 "ma"라는 이름으로 등록되어 있는 개체 가져오기
//		MyApp myApp = context.getBean(MyApp.class)		//스프링에 등록되어 있는 객체 중 MyApp 타입의 객체 가져오기
		
//		MyApp myApp2 = (MyApp) context.getBean("ma");	//스프링에 등록된 객체는 기본이 싱글톤 패턴
//		System.out.println(myApp == myApp2);			//태그에서 scope속성 값을 이용해 singleton등의 패턴 설정 가능
		
		myApp.sayHello();
		myApp.sayBye();
		
		
		String[] names = context.getBeanDefinitionNames();	//스프링에 등록된 모든 객체들의 이름들을 가져오기
		
		for(String n : names) {
			System.out.println(n);
		}
		
	}
	
}