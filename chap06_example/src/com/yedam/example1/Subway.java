package com.yedam.example1;

public class Subway {

	//필드
	private String lineNumber;
	private int money; //승객들이 내는 돈을 누적 하기 위하여
	private int passengerCount; //승객이 몇명이나 타는지?
	private int pay;
	
	//생성자
	public Subway (String lineNumber, int pay) {
		this.lineNumber = lineNumber; // 지하철 이름에 대한 정보
		this.pay = pay; //학생이 지불하는 금액에 대한 정보
	}
	
	//메서드
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++; //사람이 탈때마다 증가시켜야함
		
	}
	public void showInfo() {
		System.out.print(lineNumber + "의 승객은 ");
		System.out.print(passengerCount + "명이고, 수입은 ");
		System.out.print(money + "원 입니다.\n");
	}
	 
}
