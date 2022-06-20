package com.yedam.java.ch0702;

public class Car { //설계도
	
	//필드 - 재료
	Tire frontLeftTire = new Tire("앞왼쪽", 6); //돌아가는 최대 회수
	Tire frontRightTire = new Tire("앞오른쪽",2);
	Tire backLeftTire = new Tire("뒤왼쪽",3);
	Tire backRightTire = new Tire("뒤오른쪽",4);
	
	//생성자
	
	
	//메소드 - 기능
	int run( ) {
		System.out.println("[자동차가 달립니다.]");
		if(frontLeftTire.roll() == false) { //false는 펑크 났니? 계속 묻는중임 
			stop();
			return 1; //어느위치에 펑크가 났는지 알려주는거 1은 임의의 숫자임
		}
		if(frontRightTire.roll() == false) { //if else하면 if문만 돌기 때문에 따로 if로 만든것
			stop();
			return 2; 
		}
		if(backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if(backRightTire.roll() == false) {
			stop();
			return 4;
		}
		
		return 0; //어느 if문에도 해당이 안되면
	}
	
	void stop () {
		System.out.println("[자동차가 멈춥니다.]");
	}
	
}
