package com.yedam.java.ch0701;

public class Phone { //부모

	String model;
	String color;
	
	//생성자를 만들었으면 DMB에 super을 쓸 수 없음 디폴트 일때만 dmb에 public 가능
	public Phone(String model, String color ) {
		this.model = model;
		this.color = color;
	}
	final void powerOn() { ///final이 붙으면 상속 할 수 없음
		System.out.println("전원을 켭니다.");
	}

	final void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	protected void bell() {
		System.out.println("벨이 울리고 진동을 일으킵니다.");
	}
	
	void call() {
		System.out.println("통화를 합니다.");
	}
}
