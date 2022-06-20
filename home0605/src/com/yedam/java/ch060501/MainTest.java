package com.yedam.java.ch060501;

public class MainTest {

	public static void main(String[] args) {
		
		//휴먼클래스 타입으로 변수를 1개만 선언해야함
		
		Human human = new StandardWeightInfo("홍길동",168,45);
		human.getInformation();
		
		human = new ObesityInfo("박돌이",168,90);
		human.getInformation();
	
	}

}
