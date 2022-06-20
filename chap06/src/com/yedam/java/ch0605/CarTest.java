package com.yedam.java.ch0605;

public class CarTest {

	public static void main(String[] args) {
		
	//	CarTest ct = new CarTest(); //인스턴스 메서드를 정적 메서드 안에서 사용하기 위해서는 new를 꼭 써야함
	// ct.print();
	print(); //정적 메서드를 사용했을경우
		
	Car myCar = new Car("포르쉐");//정적 메서드 내에서 new를 쓰면 인스턴스를 사용 가능하다. 원칙은 불가능
	Car yourCar = new Car("벤츠");
	
	myCar.run();
	System.out.println(yourCar.speed);
	yourCar.run();
	}
	
	public static void print() { //정적 메서드를 만든것
	System.out.println("인스턴스 메소드입니다.");
	}
}
