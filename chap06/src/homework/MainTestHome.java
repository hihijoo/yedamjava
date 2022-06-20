package homework;

import java.util.Scanner;

public class MainTestHome {

	public static void main(String[] args) {
	
		
	boolean run = true;
	Scanner sc = new Scanner(System.in);
	CalculatorHome Cal = new CalculatorHome();
	
	while (run) {
		System.out.println("\n1.학생수 입력 2.학생점수 등록 3.학생점수 전체조회 4.학생정보 분석 5.종료");
		System.out.println("선택>");
		int selectNum = Integer.parseInt(sc.nextLine());
		
		if(selectNum == 1) {
			System.out.println("학생수 입력>");
			int count = Integer.parseInt(sc.nextLine());
			Cal.setStudentNum(count);
		} else if (selectNum == 2) {
			System.out.println("학생점수 등록>");
			int score = Integer.parseInt(sc.nextLine());
			Cal.setStudentScore(score);
		}else if (selectNum == 3) {
			Cal.printScores();	
		}else if (selectNum == 4) {
			Cal.printResult();
		}else if (selectNum == 5) {
			run = false;
			System.out.println("종료합니다.");
		}	
	}		
	}

}

