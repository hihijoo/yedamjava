package com.yedam.java.ch0606;

public class Car {

	//필드
	private int speed;
	private boolean stop;
	
	//생성자
	
	//메소드
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed < 0 ) { //스피드가 -면 0으로 나오게
			this.speed = 0;
			return;
		}else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop; 
		this.speed = 0; //차가 멈췄을때 스피드 값은 0으로 지정해둔것
	}
}
