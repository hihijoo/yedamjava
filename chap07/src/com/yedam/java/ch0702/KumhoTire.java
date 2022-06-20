package com.yedam.java.ch0702;

public class KumhoTire extends Tire { 

	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
		// TODO Auto-generated constructor stub
	}

	//메소드
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Kumho Tire 수명 : " +(maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("*** " + location + "Kumho Tire 펑크 ***");
			return false;
		}
		
	}
	
}
