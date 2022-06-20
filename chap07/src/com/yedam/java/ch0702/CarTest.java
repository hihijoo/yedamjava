package com.yedam.java.ch0702;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car(); //car에서 가져온것
		
		for(int i=1; i<=5; i++) { //car run값을 돌리는중임 (5번)
			int problemLocation = car.run(); //car에 있는 return1234 를 바다옴
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞왼쪽 Tire 교체");
				car.frontLeftTire =  new HankookTire("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 Tire 교체");
				car.frontRightTire =  new KumhoTire("앞오른쪽", 14);
				break;
			case 3:
				System.out.println("뒤왼쪽 Tire 교체");
				car.backLeftTire =  new HankookTire("뒤왼쪽", 13);
				break;
			case 4:
				System.out.println("뒤오른쪽 Tire 교체");
				car.backRightTire =  new KumhoTire("뒤오른쪽", 12);
				break;
			}
		
			System.out.println("===================================");
		
		}
		
	}

}
