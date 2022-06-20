package com.yedam.example2;

public class CardFactory { //싱글톤 -인스턴스를 외부에서 만들지 않음, 인스턴스를 통해서 기능을 하게 하는것
	

	//필드
	private static CardFactory instance = new CardFactory();
	
	//생성자
	private CardFactory() {} //외부에서 사용못하게 막은 상황
	
	//매소드
	public static CardFactory getInstance() {
		return instance;
	}
	
	//카드팩토리가 실제로 하는 기능 instance를 이용해서 기능을 하라? 싱글톤이니까
		//static 없음
	public Card createCard() {
		return new Card();
	}
	
}
