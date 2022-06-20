package control;

import java.util.Scanner;
/*
 * 
 * 1. 사각형 2. 삼각형 0.종료
 * 
 */
public class MenuArea {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	int menu; //변수 선언을 먼저 해야함
	
	do {
			menu =Integer.parseInt(scan.nextLine());
			
			if(menu == 0) {
				break;
			} else if (menu == 1) {
				System.out.println("사각형");		
			} else if (menu == 2) {
				System.out.println("삼각형");
			} else {
				System.out.println("다시 입력하세요.");
			}
	 	} while (true);
	}
}