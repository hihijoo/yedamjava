package com.yedam.java.ch0802;

public class Car {

	Tire frontLeftTire = new KumhoTire();
	Tire frontRightTier = new KumhoTire();
	Tire backLeftTire = new KumhoTire();
	Tire backRightTire = new KumhoTire();
	
	void run () {
		frontLeftTire.roll();
		frontRightTier.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
}
