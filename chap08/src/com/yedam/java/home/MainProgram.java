package com.yedam.java.home;

import java.util.Scanner;

public class MainProgram {

	//필드
	private Scanner sc = new Scanner(System.in);
	private BookAccess dao = BookRepo.getInstace(); //dao (data access object)
	private Program pro = new BookProgram();
	
	//생성자
	public MainProgram() {
		while(true) {
			//메뉴출력
			pro.menuPrint();
			//메뉴선택
			int menuNo = menuSelect();
			 
			//메뉴 실행
			if(menuNo == 1) { //도서정보입력
				pro.inputInfo(dao);
			}else if (menuNo ==2) { //전체조회
				pro.pirntAllInfo(dao);
			}else if (menuNo ==3) { //검색
				pro.printInfo(dao);
			}else if (menuNo ==4) { //수정
				pro.printUpdate(dao);
			}else if (menuNo ==5) { //삭제
				pro.printDelete(dao);
			}else if (menuNo ==6) { //분석
				pro.printRepo(dao);
			} else if (menuNo ==7) {//종료
				exit();
				break;
			}
			}
		}
	
	
	//메소드
	
	private int menuSelect() {
		System.out.print("선택>");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	
}
