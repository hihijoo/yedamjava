package com.yedam.java.ch0802;

public class Driver {
	
	void drive(Vehicle vehicle) { //vehicle을 매개변수로 줘야함
		if(vehicle instanceof Bus) {
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}
		
		vehicle.run();
	}

}
