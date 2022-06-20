package control;

import java.util.Scanner;

public class ControlMain {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	//변수를 먼저 선언해야함
	int score; // 점수 입력
	String grade; //등급
	
	//조건이 맞을 동안은 계속 실행
	do {
			//점수를 키보드로부터 입력
			score = Integer.parseInt(scan.nextLine()); // scan.nextInt()같은것
			if(score == 0) {
				break; //반복문 빠져나감
			}
			// 등급계산 조건문 	
			if(score>=90) {
				grade =  "A등급";	
			} else if (score>80) {
				grade = "B등급";
			} else if (score>70) {
				grade = "C등급";
			} else {
				grade = "D등급";
			} 
			//등급 결과 출력
			System.out.printf("%d 성적은 %s입니다.", score, grade);

		} while(score != 0); //0이면 끝내라
	
		System.out.println("프로그램 종료");
	}
}


