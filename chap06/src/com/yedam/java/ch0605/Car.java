package com.yedam.java.ch0605;

public class Car {
	
	//필드
	public String model;
	public int speed;
	
	// 정적 필드 - 생산수량
	public static int count;
	
	//생성자
	public Car(String model) {//클래스와 동일한 이름을 가짐. 
		this.model = model; //임의로 생성자를 만든것이라 기본생성자를 만들어 줘야함.
		Car.count++; //static이 붙은 필드에는 this를 사용하면 안됨
	
	}
	//메소드
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void run() {
		for(int i = 10; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속:" + this.speed+"km/h)");
		}
	}
}
