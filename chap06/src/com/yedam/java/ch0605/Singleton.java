package com.yedam.java.ch0605;

public class Singleton {

	//필드
	private static Singleton singleton = new Singleton(); //private로 막았기 때문에 외부에 static을 붙여야 사용가능
	//필드에 직접 접근 못하게 private를 붙여야함
	
	//생성자
	private Singleton() { //생성자를 내부에서 쓸 수 없게 막은것.
		
	}
	//메소드
	static Singleton getInstance( ) {
		return singleton;
	}

}
