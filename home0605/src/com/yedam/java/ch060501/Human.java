package com.yedam.java.ch060501;

public class Human {

	//필드
	public String name; 
	public double height;
	public double weight;
	
	//생성자
	Human(String name,double height,double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	//메소드
	 public void getInformation() {
	System.out.println(name + "님의 신장 "+height +", 몸무게 "+height +"입니다."); 
	 }
	
}
