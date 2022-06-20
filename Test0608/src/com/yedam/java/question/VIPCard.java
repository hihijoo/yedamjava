package com.yedam.java.question;

public class VIPCard implements Payment {

	
	//필드
	private String name;
	private String grade;
	private double saleRatio; //할인율
	private int point;
	private double pointRatio; //적립율
	
	
	//생성자
	public VIPCard() {
		this.name = "VIPCard";
		this.grade = "GOLD";
		this.saleRatio = 0.1;
		this.pointRatio = 0.03;
		
	}
	
	//메소드
	@Override
	public int offline(int price) {
		point = (int) (price * pointRatio);
		price = (int) (price *(1-(0.01+saleRatio)));
		
		return price;
	}

	@Override
	public int online(int price) {
		point = (int) (price * pointRatio);
		price = (int) (price *(1-(0.03+saleRatio)));
		
		return price;
	}

	@Override
	public int simple(int price) {
		point = (int) (price * pointRatio);
		price = (int) (price *(1-(0.05+saleRatio)));
		
		return price;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드명 : "+ name);
		System.out.println("적용 등급 : "+ grade);
		System.out.println("할인율 : "+ saleRatio);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 : "+ point);
		
	}

}
