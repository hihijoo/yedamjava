package com.yedam.java.ch0602;

public class Car {

	//필드
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;  //값을 초기화 해서 0이 나옴
	//필드에서는 this를 사용 할 수 없음.
	
	
	Car() {} //기본 생성자
	
	Car(String color) {
		//this.color = color; //클래스 내부에서만 사용할 수 있는 연산자. 인스턴스의 필드ㅇ 클래스필드가x
		this("그랜저",color,350); //순서가 중요 this부터 하고
		company = "기아";
	}
	
	Car(String model, String color) {
		//this.model = model;
		//this.color = color;
		this(model,color,350); //생성자를 뜻함. 필드는 this.임
	
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
