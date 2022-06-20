package com.yedam.java.example1;

public class Vip extends Customer {
	
	
	//필드
	String counselor; //무조건 소문자로
	double discountRatio;
	
	// 생성자
		public Vip(int customerId, String customerName,String counselor) {
		super(customerId,customerName);
		this.customerGrade ="VIP"; //기본등급은 실버
		this.bonusRatio = 0.05;
		this.discountRatio = 0.15;
		this.counselor = counselor;
	
		}
		
		//메소드
		@Override
		public int calcPrice(int price) {
			//1. 보너스 포인트 적립
			//this.bonusPoint += price*this.bonusPoint;
			//2. 할인율이 적용된 가격
			//return (int) (price *(1-this.discountRatio)); 밑에 한줄이랑 같은것
			
			return (int) (super.calcPrice(price)*(1-this.discountRatio));	//super해도 자식 메소드 먼저 검토하기 때문에 this 안써도 됨	
		}
		
		@Override
		public String showInfo() {
			return super.showInfo() + "\n" + "담당 상담원은 " + counselor + "입니다.";
		}

		public String getCounselor() {
			return counselor;
		}
		
		public void setCounselor(String Counselor) {
			this.counselor = counselor;
		}

		
}
