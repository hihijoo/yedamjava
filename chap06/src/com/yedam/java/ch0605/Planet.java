package com.yedam.java.ch0605;

public class Planet {

	//필드
	final int radius; //행성 크기는 한번 정해지면 잘 안바뀌니까
	static final double pi = 3.1459; //final은 고정시킴 
		
	//생성자 - static은 생성자를 안만들어도 됨.
	Planet(int radius) {
		this.radius = radius;
	}
	
	//메소드
	void getArea() {
		double result = 4 * Planet.pi * this.radius * this.radius; 
		System.out.println("행성의 표면적 : " + result);
	}
}
