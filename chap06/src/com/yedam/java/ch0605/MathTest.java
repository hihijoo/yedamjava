package com.yedam.java.ch0605;

public class MathTest {

	public static void main(String[] args) {

		double result1 = 10 * 10 * Math.pi; //정적메서드라서 굳이 인스턴스를 만들 필요가 없음.
		int result2 = Math.plus(10, 5);
		int result3 = Math.minus(10, 5);
		
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
	}

}
