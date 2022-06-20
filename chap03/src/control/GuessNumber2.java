package control;

import java.util.Scanner;

public class GuessNumber2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int rand = (int)(Math.random()*10)+1;	// 10중에 랜덤으로 하는거 항상 +1해야함
		int num;		//유저가 입력하는 값
		int count =1;
		
		do {
			count ++;
			
			num = scan.nextInt();
			if (rand > num) {
				System.out.println("크다");
			} else if ( rand < num) {
				System.out.println("작다");
			} else {
				System.out.println("정답입니다.");
			break;
			}
			if (count>5) {
				break;
			} 
		} while(true);
	
	}
}
