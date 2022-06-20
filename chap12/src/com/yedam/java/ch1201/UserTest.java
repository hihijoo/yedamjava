package com.yedam.java.ch1201;

public class UserTest {
	public static void main(String[] args) {
	Calculator cal = new Calculator();
	//cal.setMemory(100);
	
	User user1 = new User();
	user1.setCalculator(cal);
	user1.start();
	//user100
	//예상했을때 200이지만 300이 나옴
	
	User user2 = new User();
	user2.setCalculator(cal);
	user2.start();
	//user200
	//300
	

	
}
}
