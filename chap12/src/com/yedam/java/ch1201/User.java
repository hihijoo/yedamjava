package com.yedam.java.ch1201;

public class User extends Thread {
	private static int serial = 0;
	private Calculator cal;
	private int numInfo;
	
	public void setCalculator(Calculator cal) {
		serial += 100;
		this.setName("User" + serial);
		//this.setName("User" + (++serial));
		this.cal = cal;
		this.numInfo = serial; // 시리얼 번호를 복사함
	}
	
	@Override
	public void run() {
		cal.setMemory(100+numInfo); //메모리 값은 100+200 해서 300이 나옴
	}
}
