package com.yedam.java.ch0606;

import com.yedam.java.ch0605.Car; //내가 현재 패키지안에 없는걸 사용하고자 할때 import함

public class MainTest {

	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		myCar.run();
		
		
	}

}
