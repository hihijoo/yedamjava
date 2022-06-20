package com.yedam.java.ch1102;

public class StringTest2 {

	public static void main(String[] args) {
	
		//toLowerCase & toUpperCase
		String str1 = "JAVA Programming";
		String str2 = "JAVA PROGRAMMING"; 
		
		if(str1.equals(str2)) {
			System.out.println("str1과 str2가 같은 값입니다.");
		} else {
			System.out.println("str1과 str2가 다른 값입니다.");
		}

		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		if(val1.equals(val2)) {
			System.out.println("val1과 val2가 같은 값입니다.");
		} else {
			System.out.println("val1과 val2가 다른 값입니다.");
		}
		
		if(str1.equalsIgnoreCase(str2)) { //대문자 소문자 상관없이 같게 봄
			System.out.println("str1과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1과 str2가 다른 값입니다.");
		}

	//trim
		String subject = "          자바       프로그래밍                ";
		String newData = subject.trim(); //앞뒤에 공백은 제거 할 수 있지만 중간에 공백은 불가능함
		System.out.println(newData);
	
		String result1 = newData.substring(0,2); //"자바"로 하면 자바 뒤에 공백과 프로그램밍이 다같이 딸려옴 그래서 숫자로 해야함
		String result2 = newData.substring(newData.indexOf("프로그래밍"));
	
		System.out.println(result1+" " +result2);
	
		
		//valueOf
		String value1 = String.valueOf(10);
		String value2 = String.valueOf(10.5);
		String value3 = String.valueOf(true);
		
		String value4 = "" + 100;
		
	}
	
	

}
