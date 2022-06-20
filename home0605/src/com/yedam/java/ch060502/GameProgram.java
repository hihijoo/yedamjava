package com.yedam.java.ch060502;

import java.util.Scanner;

public class GameProgram {
	
		private Keypad game; //키패드에 알피지랑 아케이드를 자식으로 만들어놔서 여기서는 선언만 해도 쓸 수 있음 
		
		//필드
		Scanner sc = new Scanner(System.in);
		int num = (int)(Math.random()*2 +1);

	
		//생성자
		GameProgram() {
		if(num == 1 ) {
			game = new RpgGame();
		} else if(num==2) {
			game = new ArcadeGame();
		} 
		
		while(true) {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			int menu = menuSelect();
			//메뉴 실행
			if(menu == 1) {
				game.leftUpButton();
			} else if (menu == 2) {
				game.leftDownButton();
			} else if (menu ==3) {
				game.rightUpButton();
			} else if (menu ==4) {
				game.rightDownButton();
			} else if (menu == 5) {
				game.changeMode();
			} else if (menu == 0) {
				SelectNum();
			} else if(menu == 9) {
				SelectExit();
				break;
			} else {
				printInputError();
			}
	
		}
		}
		
		
		//메소드
	
		public void printMenu() {
		System.out.println("============================================================================================");
		System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println("============================================================================================");
		}
		
		
	
		
		int menuSelect() {
			System.out.println("choice>>");
			return Integer.parseInt(sc.nextLine());
		}
		
		void SelectNum() {
			if(game instanceof RpgGame ) {
				game = new ArcadeGame();
			} else {
				game = new RpgGame();
			}
		}
		
		void SelectExit() {
			System.out.println("EXIT");
		}

		void printInputError() {
			System.out.println("메뉴를 잘못 선택하였습니다. 0-5 또는 9를 넣어주세요.");
		}
		
}

