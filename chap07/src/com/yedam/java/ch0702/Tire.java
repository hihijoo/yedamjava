package com.yedam.java.ch0702;

public class Tire { //설계도
	
	//필드
	public int maxRotation; //타이어 수명
	public int accumulatedRotation; //타이어 누적 회수
	public String location; //타이어의 위치
	
	//생성자
	public Tire(String location, int maxRotation ) { //앞뒤인지 왼뒤인지 표시랑, 최대회수
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메소드
	public boolean roll() {
		++accumulatedRotation; //회수는 계속 누적되는 중
		if(accumulatedRotation < maxRotation) { //누적회전수가 max보다 커지면 펑크가 나는 것으로 함
			System.out.println(location + " Tire 수명 : " +(maxRotation - accumulatedRotation) + "회");
			return true; //누적회전수가 최대보다 아직 작음
		}else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false; //누적회전수가 최대보다 큼
		}
		
	}
	
}
