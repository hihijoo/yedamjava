package com.yedam.java.ch0605;

public class PlanetTest {

	public static void main(String[] args) {
	System.out.println("pi : " + Planet.pi);
	//Planet.pi = Math.pi; - static final로 고정해놨기 떄문에 변경이 안됨 오류남 but 누구나 접근해서 사용할 수는 있음
	
	Planet earth = new Planet(6400);
	System.out.println("earth : " + earth.radius);
	Planet moon = new Planet(1500);
	System.out.println("moon : " + moon.radius);
	
		
	}

}
