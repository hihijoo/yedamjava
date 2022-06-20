package com.yedam.java.ch1101;

import java.util.Date;

public class ToStringTest { //클래스 정보를 문자 타입으로 출력
	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.toString());
		
		Date date = new Date();
		System.out.println(date.toString());

		Member member = new Member("홍길동");
		System.out.println(member);
		System.out.println(member.toString());
	
	}
}
