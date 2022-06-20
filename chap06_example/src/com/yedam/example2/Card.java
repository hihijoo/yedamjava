package com.yedam.example2;

public class Card {

	//필드
	private static int serialNum = 1100; //임의로 저장값
			//프라이빗으로 막았지만 공유할거라서 static
	
	private int cardId;
	
	//생성자
	public Card() { //카드를 발급하겠다.
		serialNum++;
		cardId = serialNum;
	}
	
	//메소드
	public static int getSerialNum() {
		return serialNum;
	}
	public int getCardId() {
		return cardId;
	}

}
