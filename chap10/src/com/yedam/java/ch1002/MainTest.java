package com.yedam.java.ch1002;

public class MainTest {

	public static void main(String[] args) {
	try {
		//원래 실행하고자 하는 코드
		
	} catch(Exception e) {
		// 예외가 발생한 경우 처리 코드
		
	} finally {
		//정상적으로 실행하든 에외가 발생했든 반드시 실행되어야 하는 코드
		
	}
	String data1 = null;
	String data2 = null;
	
	try {
		int value1 = Integer.parseInt(data1);
		
		data1 = args[0];
		data2 = args[1];
	} catch(ArrayIndexOutOfBoundsException e) { //내가 어느 예외를 처리하겠다고 선언한것만 가능 모든 예외를 처리 하고 싶으면 다중 catch를 써야함
		// e.printStackTrace(); //예외와 상관 없이 무조건 출력
		System.out.println("실행 매개값의 수가 부족합니다.");
		return; //메소드 내에서는 어느 위치든 사용이 가능하기 때문에 '메인 메소드 종료'는 실행되지 않음
	} catch(NumberFormatException e) {
		System.out.println("숫자 형식에 맞춰 입력해주세요.");
		return;
	} catch(Exception e) { //항상 마지막에 넣어야함. 맨처음에 넣어버리면 뒤에 arry나 number까지 실행이 되지 않음
		System.out.println("기타");
		return;
	} finally { //예외라도 반드시 처리해야하는 경우라면 넣어줘라 ++무조건 실행됨++
		System.out.println("필수 구문");
	}
	
	System.out.println("메인 메소드 종료"); 
	
	
	try { 
		findClass();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (NullPointerException e) {
		e.printStackTrace();
	}
	
	}

	//예외 떠넘기기
	public static void findClass() throws ClassNotFoundException, NullPointerException { //예외를 호출한 곳을 떠넘기는것
	 Class clazz = Class.forName("java.lang.String"); //string 클래스의 풀네임
	}

}
