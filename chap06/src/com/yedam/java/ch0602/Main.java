package com.yedam.java.ch0602;

public class Main { //자바가 알아서 생성자를 만즐어준것

	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		myCar.speed = 100;
		System.out.println(myCar.speed);
		
		
		System.out.println();
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		System.out.println(yourCar.speed); //값을 초기화 했기 때문에 0이 나옴

		
		System.out.println();
		Car blueCar = new Car("Blue");
		System.out.println(blueCar.color);
		
		
		System.out.println();
		Car newCar = new Car();
		System.out.println(newCar.color);
		
		
	}

}
