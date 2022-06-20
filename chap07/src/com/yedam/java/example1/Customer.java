package com.yedam.java.example1;

public class Customer {

	// 필드
	int customerId; //고객 아이디
	String customerName; // 고객이름
	String customerGrade; //고객등급
	int bonusPoint; //보너스 포인트
	double bonusRatio; //보너스 포인트 적립율
	
	// 생성자
	public Customer(int customerId, String customerName) {
	this.customerId = customerId;
	this.customerName =customerName;
	this.customerGrade ="SILVER"; //기본등급은 실버
	this.bonusRatio = 0.01;
	}
	
	// 메소드
	public int calcPrice(int price) { //포인트 적립
		this.bonusPoint += price * this.bonusRatio;
		return price;
	}
	
	public String showInfo() {
		return customerName + "님의 등급은 " + customerGrade+ "이며, 보너스 포인트는 " 
				+ bonusPoint + "입니다.";
	}
	public int getCustomerId( ) {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade( ) {
		return customerGrade;
	}
	
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getbonusPoint() {
		return bonusPoint;
	}
	
	public void setbonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	public double getbonusRatio() {
		return bonusRatio;
	}
	
	public void setbonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	
}
