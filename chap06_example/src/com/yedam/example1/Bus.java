package com.yedam.example1;

public class Bus {

	
	//필드
	private String busNumber;
	private int money;
	private int passengerCount;
	private int pay;
	
	//생성자
	public Bus (String busNumber, int pay) { //생성자는 class와 항상 이름이 똑같아야함
		this.busNumber = busNumber;
		this.pay = pay;
	}
	
	//메서드
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	public void showInfo() {
		System.out.print(busNumber + "의 승객은 ");
		System.out.print(passengerCount + "명이고, 수입은 ");
		System.out.print(money + "원 입니다.");
	}
	
}
