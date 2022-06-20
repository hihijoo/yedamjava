package com.yedam.java.ch0606;

public class CarTest {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		myCar.setSpeed(50); //myCar.speed = -50;		
		System.out.println("현재 속도 : " + myCar.getSpeed()); //get으로 값을 읽어옴
		
		
		if(!myCar.isStop()) { 	//false문이 뜨더라도 !를 만나면 true가 되서 계속 실행되도록
			myCar.setStop(true);	//if문은 무조건 true일때만 계속 돌아가기 때문에
		}
		
		System.out.println("현재 속도 : " + myCar.getSpeed());	//차가 멈췄기 때문에 속도가 0이 나오는것
	
	}

}
