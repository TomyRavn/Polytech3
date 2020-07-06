package com.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class MyAdvice {
	
	public void log(JoinPoint jp) {
		
		Object target = jp.getTarget(); //실행대상 메서드가 속한 객체
		Signature sig = jp.getSignature();//실헝대상 메서드
		Object[] args = jp.getArgs();//실험대상 메서드에 전달되느 ㄴ메서드
		
		System.out.println("실행전 로그 :" + target.getClass().getSimpleName()
				+ ":" + sig.getName());
	}
	

}
