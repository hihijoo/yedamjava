package com.yedam.java.ch0701;

				//자식			//부모
public class Computer extends Calculator { //만들때 extends 설정이 가능함
	
	@Override //자바가 한번더 부모꺼를 확인하는것
	double areaCircle(double r) { //내용은 상관없지만 골격은 부모꺼를 유지해야함
		System.out.println("Computer 객체");
		return Math.PI*r*r;
	}
 
	
	
	void print() {
		super.areaCircle(5);
		areaCircle(5);
		
	}
}
