package control;

import java.util.Scanner;
/*
 * 숫자맞추기 게임
 * 	반복
 * 키보드 정수값을 읽어서 num 변수에 저장
 * rand > num "크다" 출력
 * rand < num "작다" 출력
 * rand == num break
 */
public class GuessNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int rand = (int)(Math.random()*10)+1;	// 10중에 랜덤으로 하는거 항상 +1해야함
		int num;		//유저가 입력하는 값
		String result;	//비교결과를 저장
		
		do {
			num = Integer.parseInt(scan.nextLine());
			if (rand == num) {
				break;	
			}
			if (rand > num) {
				result ="크다";
			} else {
				result ="작다";
			}
			System.out.println(result);
		} while (true);
		
		System.out.println("정답입니다.");
	
	}

}
