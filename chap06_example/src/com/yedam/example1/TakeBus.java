package com.yedam.example1;

public class TakeBus {

	public static void main(String[] args) {
		Student hong = new Student("NOH", 10000);
		Bus green = new Bus("급행6", 1800);
		
		hong.takeBus(green);
		
		hong.showInfo();
		green.showInfo();
		
		

	}

}
