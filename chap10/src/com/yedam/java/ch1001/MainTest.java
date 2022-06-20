package com.yedam.java.ch1001;

public class MainTest {

	public static void main(String[] args) {
		//실행예외 -> 문법적으로는 문제가 없고 실제 실행 시 발생하는 예외
		
		//NullPointException
		String data = null;
		if(data != null) {
		System.out.println(data.toString()); //toString 객체를 설명해주는 문자열을 리턴
		}
	
		//ArrayIndexOutOfBoundsException
		if(args.length >=2 ) {
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("asrg[0] : " + data1);
		System.out.println("asrg[0] : " + data2);
		} 
	
		//NumberFormatException
		
		
		/* String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		
		int result = value1 + value2;
		 */
		
		//ClassCastException
		changeDog(new Dog());
		changeDog(new Cat());
		
	}
	public static void changeDog(Animal animal) {
		if(animal instanceof Dog){ //animal instanceof Dog
		Dog dog = (Dog) animal;
		}
	}
}


	class Animal{}
	class Dog extends Animal {}
	class Cat extends Animal {}
