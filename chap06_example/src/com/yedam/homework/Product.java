package com.yedam.homework;

public class Product {

	//상품에 대한 정보를 가지는 클래스
	
	//상품명과 가격을 가져야함
	//필드
	private String name;
	private int price;
	
	//생성자
	//public Product () {} //아무것도 안준 상태로 만들때 쓰는것
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	//메소드
	
	public void setName(String name) { //이름을 계속 바꿀거면 필요함 안바꿀거면 getname만 있으면 됨
		this.name = name;
	}
	public String getName() {
		return name; //작업을 마치면 호출 한 곳으로 가라
	}
	

	public void setPrice(int price) {
		this.price = price;
		
	}
	public int getPrice() {
		return price;
	}
	
	public void showInfo() {
		System.out.println(name + " : " + price);
	}

}