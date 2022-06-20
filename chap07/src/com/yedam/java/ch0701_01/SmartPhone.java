package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {

	public SmartPhone(String model, String color) { //생성자가 필요함
		super(model, color);
		
	}
	
	void print() {
		super.bell();
		
	}

	
 // 마우스 오른쪽 -> 소스 -> 오버라이드
	@Override //final 한건 오버라이딩에 표시가 안됨
	public void bell() { //protected이상의 값을 해야지 오버로딩이 됨 그래서 public을 붙여줘야함
		super.bell(); //호출은 문제가 없음 (protected)
		System.out.println("벨 소리 : 싸이- that that!");
	}

	@Override
	void call() {
		super.call();
		System.out.println("안내 문구 : 전화는 용건만 간단히");
	}
	
	void print() { //private는 본인만 쓸 수 있음
		System.out.println("테스트 :  싸이- that that!");
	}
	
}
