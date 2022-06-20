package com.yedam.java.ch0802;

public class CarTest {

	public static void main(String[] args) {

		Car myCar = new Car();
		myCar.run();
	
		System.out.println();
		
		myCar.frontLeftTire = new HankookTire(); //앞 왼쪽 금호가 이상한거 같아서 한국으로 바꾼것
		myCar.frontRightTier = new HankookTire();// 앞오른쪽을 한국으로 교체한것
		
		myCar.run();
	}

}
