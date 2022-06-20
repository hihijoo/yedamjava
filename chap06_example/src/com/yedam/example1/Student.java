package com.yedam.example1;

public class Student {
	//필드
	private String name;
	private int money;
	
	//생성자
	public Student (String name, int money) {
		this.name = name; // 학생 이름에 대한 정보
		this.money = money; //학생이 지불하는 금액에 대한 정보
	}
	
	//지하철매서드
	public void takeSubway(Subway subway) { //학생이 무엇을 타는지
		int pay = subway.getPay(); //돈을 얼마 내야하는지 체크하는것 
		this.money -= pay; //내가 지불하는 돈은 -가 됨
		subway.take(pay); //지하철에 내가 지불하는 돈 (-만큼) 주는것
	}
	
	//버스 매서드 -오버로딩
	public void takeBus(Bus bus) {
		int pay = bus.getPay(); //버스에 지불하는 돈
		this.money -=pay; //학생이 가진 돈에서 -해야함
		bus.take(pay);
		
	}
	public void showInfo() {
		System.out.println(name + "님의 남은 돈은 " +money + "입니다.");
}
}
