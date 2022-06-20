package com.yedam.java.home;

public interface Program {

	
	//메뉴
	public void menuPrint();
	
	//정보입력
	public void inputInfo(BookAccess access);
	
	//입력된 전체정보를 출력
	public void pirntAllInfo(BookAccess access); 
	
	//특정 조건의 정보를 출력
	public void printInfo(BookAccess access);
	
	//갱신
	public void printUpdate(BookAccess access);
	
	//수정
	public void printDelete(BookAccess access);
	
	//분석
	public void printRepo(BookAccess access);
	
}
