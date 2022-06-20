package com.yedam.example1;

public class TakeSubway {

	public static void main(String[] args) {
		Student hong = new Student("Hong", 5000);
		Subway green = new Subway("2호선", 1500);
		
		hong.takeSubway(green); //take(subway)에 green을 생성해서 넣은것
		
		
		Bus bus = new Bus("급행 2번" ,1250);
		hong.takeBus(bus);
		
		
		hong.showInfo();
		green.showInfo();
		bus.showInfo();
		
		//환승해서 버스 타는건 어떻게 나타내는거지??
		
		
	}

}
