package com.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//스프링 = IOC/DI 와 AOP 기능을 지원하는 객체(Bean)들을 담고 있는 컨테이너 = ApplicationContext

public class AppMain {
	public static void main(String[] args) {
//		MyApp myApp = new MyApp();
		
//		클래스 패스에서 "com/exam/context.xml" 설정파일에 적혀있는대로 
//		객체들을 생성하여 담고 있는 ApplicationContext 를 생성
//		ApplicationContext = 스프링 본체 == 객체들을 담고있는 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/exam/context.xml");
		
//		MyConfig 클래스에 자바로 작성한 설정 내용대로 스프링 객체 컨테이너를 생성
//		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		MyApp myApp = (MyApp) context.getBean("ma"); //스프링에 "ma"라는 이름으로 등록되어 있는 객체 가져오기
//		MyApp myApp = context.getBean(MyApp.class); //스프링에 등럭되어 있는 객체 중 MyApp 타입의 객체 가져오기
		
//		MyApp myApp2 = (MyApp) context.getBean("ma"); //스프링에 "ma"라는 이름으로 등록되어 있는 객체 가져오기
//		System.out.println(myApp == myApp2);
		
		myApp.sayHello();
		myApp.sayBye();
		
				
		String[] names = context.getBeanDefinitionNames(); //스프링에 등록된 모든 객체들의 외..부..?
		for (String n : names) {
			System.out.println(n);			
		}
	}
}
