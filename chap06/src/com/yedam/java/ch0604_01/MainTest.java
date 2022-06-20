package com.yedam.java.ch0604_01;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Calculator Cal = new Calculator();
		
		while(run) {
			System.out.println("1.개수입력 | 2.숫자입력 | 3.더하기 | 4.빼기 | 5.곱하기 | 6. 나누기");
			System.out.println("선택>");
		int selectNum = Integer.parseInt(sc.nextLine());
		
		if(selectNum == 1) {
			System.out.println("개수입력>");
			int count = Integer.parseInt(sc.nextLine());
			Cal.setArraySize(count);
		} else if (selectNum == 2) {
			System.out.println("숫자입력>");
			int num = Integer.parseInt(sc.nextLine());
			Cal.setNum(num);
		} else if (selectNum == 3) {
			
			Cal.plus();
		} else if (selectNum == 4) {
			
			Cal.sub();
		} else if (selectNum == 5) {
			
			Cal.mu();
		} else if (selectNum == 6) {
			
			Cal.di();
			run = false;
			System.out.println("프로그램 종료"); 
		}
		
	}

}
}
