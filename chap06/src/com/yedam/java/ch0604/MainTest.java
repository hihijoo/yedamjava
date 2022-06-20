package com.yedam.java.ch0604;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
	
		boolean run = true; //run을 while문 밖에서도 사용하기 위해서
		Scanner sc = new Scanner(System.in);
		Program program = new Program(); //외부에 선언해야함, 내부에 선언하면 while문이 돌때마다 초기화 됨
		
		while(run) {
			System.out.println("1.학생 수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("선택>");
		int selectNo = Integer.parseInt(sc.nextLine()); //학생수를 입력받은것
		
		if(selectNo == 1) {
			System.out.println("학생 수>");
			int student = Integer.parseInt(sc.nextLine());
			program.setStudentsNum(student);
		}else if (selectNo ==2 ) {
			System.out.println("점수>");
			int score = Integer.parseInt(sc.nextLine());
			program.setStudentScore(score);
		}else if (selectNo ==3 ) {
			program.printScores(); //별도로 입력할건 없구 입력된 값만 출력
		}else if (selectNo ==4 ) {
			program.printResult(); //니가 가지고 있는 프린트를 호출해달라
		}else if (selectNo ==5 ) {
			run =  false;	
			System.out.println("프로그램 종료");
		}
		}
	}

}
