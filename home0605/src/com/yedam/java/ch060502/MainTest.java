package com.yedam.java.ch060502;

public class MainTest {

	public static void main(String[] args) {
		
		
//		RPGgame 실행
		RpgGame rpg = new RpgGame();

//		캐릭터가 위쪽으로 이동한다.
		rpg.leftDownButton();
		
//		캐릭터가 한칸단위로 점프한다.
		rpg.rightUpButton();
		
//		현재 모드 : HARD_MODE
		rpg.changeMode();
		
//		캐릭터가 두칸단위로 점프한다.
		rpg.rightUpButton();
		
//		캐릭터가 HIT 공격.
		rpg.rightDownButton();
		
//		캐릭터가 아래쪽으로 이동한다.
		rpg.leftDownButton();
		
//		현재 모드 : NORMAL_MODE
		rpg.changeMode();
		
//		캐릭터가 일반 공격.
		rpg.rightDownButton();
		
		
		System.out.println("======================");
		
//		ArcadeGame 실행
		ArcadeGame ar = new ArcadeGame();
		
//		캐릭터가 앞쪽으로 이동한다.
		ar.leftUpButton();
		
//		캐릭터가 일반 공격
		ar.rightUpButton();
		
//		캐릭터가 뒤쪽으로 이동한다.
		ar.leftDownButton();
		
//		현재 모드 : HARD_MODE
		ar.changeMode();
		
//		캐릭터가 연속 공격.
		ar.rightUpButton();
		
//		캐릭터가 앞쪽으로 이동한다.
		ar.leftUpButton();
		
//		캐릭터가 Double HIT 공격.
		ar.rightDownButton();
		
	}
}
	
