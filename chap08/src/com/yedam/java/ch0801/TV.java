package com.yedam.java.ch0801;

public class TV implements MasterControl { //구현은 임플리먼트 뒤에 마스터(리모트건트롤,스마트 컨트롤)은 인터페이스
				//위에 줄만 쓰면 오류가 뜨는데 자동으로 재정의를 해줌 
	
	private int volume; //인터페이스에서 선언하지 못한 볼륨 필드를 추가함
	
	//remotecontrol에 있던것들
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void tunrOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume >  RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
	} else if (volume < RemoteControl.MIN_VOLUME) {
		this.volume = RemoteControl.MIN_VOLUME;
	} else {
		this.volume = volume;
	}
		
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}

	
	//smartControl에 있던 것들
	@Override
	public void searchInternet(String url) {
	System.out.println(url + "을 검색합니다.");
		
	}

	@Override
	public void executeApp(String app) {
		System.out.println(app + "을 검색합니다.");
		
	}

}
