package com.yedam.java.example1;

public class Gold extends Customer {
	
	//필드
	double discountRatio;
	
	//생성자
	public Gold(int customerId, String customerName) {
		super(customerId, customerName); //부모꺼 가져오는것 
		this.customerGrade = "Gold";
		this.bonusRatio = 0.02;
		this.discountRatio = 0.1;
	}
	
	//메소드
	@Override
	public int calcPrice(int price) { 
		//1. 보너스 포인트 적립
		this.bonusPoint += price * this.bonusRatio;
		//2. 할인율이 적용된 가격
		return (int) (price *(1-this.discountRatio));
		
		// 위에 두줄과 같은것 
		//return (int) (super.calcPrice(price)*(1-this.discountRatio));

	}

	public double getDiscountRatio() {
		return discountRatio;
	}
	
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	

}
