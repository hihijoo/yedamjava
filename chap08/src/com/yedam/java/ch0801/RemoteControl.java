package com.yedam.java.ch0801;

public interface RemoteControl { //여기는 인터페이스 안이에용!

	//상수 필드
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0; //기본적인 필드 선언한다 하더라도 인터페이스 안에서 선언하니까 상수로 보는것
								//자동으로 public static final int MIN_VOLUNE = 0; 인식
	//public int MIN_VOLUME; //오류가 남 상수인데 왜 수를 안주냐고요오오오
	
	//생성자는 안돼~~~!!!! 못만들어~~!!!
	
	//추상 메소드
	public abstract void turnOn();
	public void tunrOff(); //인터페이스 안에서는 abstract를 빼도 가능 자바가 알아서 처리해줌
	public void setVolume(int volume); //단순히 볼륨값을 셋팅해놓은것 뿐
	
	//일반 메소드
	//public default void show() { //자바입장에서는 일반메서드인지 당혹스러움 기본이 추상메소드니까 그래서 default를 붙이는거임
		//System.out.println("추가한 메소드");
	}
	//정적 메소드
	

