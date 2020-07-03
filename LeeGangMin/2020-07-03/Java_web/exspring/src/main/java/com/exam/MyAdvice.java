package com.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class MyAdvice {
	
	public void log(JoinPoint jp) {
		Object target = jp.getTarget();			//실행 대상 메소드가 속한 객체
		Signature sig = jp.getSignature();		//실행 대상 메소드
		Object[] args = jp.getArgs();			//실행 대상 메소드에 전달되는 메소드
		System.out.println("실행 전 로그 : " + target.getClass().getSimpleName()
				+ " : " + sig.getName());
	}
	
}