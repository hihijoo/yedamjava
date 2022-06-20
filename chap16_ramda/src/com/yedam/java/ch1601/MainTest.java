package com.yedam.java.ch1601;

public class MainTest {

	public static void main(String[] args) {
		MyFunctionalInterface fi = () -> {System.out.println("람다식 실행");};
		
		//new연산자를 쓰지 않아도 힙메모리에 저장되어 있기 때문에 불러 올 수 있음
		fi.method();
		
		
		
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			
			//반드시 구현해야하는건 이거 하나 뿐
			@Override
			public void method() {
				System.out.println("익명 구현 객체 실행");
			}
		};
		
		mfi.method();
	}

}
