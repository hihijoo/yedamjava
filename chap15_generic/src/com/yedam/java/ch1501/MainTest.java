package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
	
		Bag bag = new Bag(); //다양한 타입을 담을 수 있음
		
		bag.set(new Note()); //1번
		Note note = (Note)bag.get(); //강제로 형변환을 해줘야함

		bag.set("신운하"); //2번
		String name = (String)bag.get();	
		
		
		Box<Note, String, Integer> box = new Box<>(); //지정된 값만 받을 수 있음 note,string, integer만...
		
		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();
		
		Box<Car, Bus, Taxi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setK(new Taxi());
		vehicle.setV(new Bus());
		
		Car car = vehicle.getT();
		Bus bus = vehicle.getV();
		Taxi taxi = vehicle.getK();
	}

}

	
	class Car {}
	class Bus {}
	class Taxi {}
