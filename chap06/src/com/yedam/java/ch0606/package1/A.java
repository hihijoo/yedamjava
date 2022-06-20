package com.yedam.java.ch0606.package1;

public class A {
	
	//필드
	A a1= new A(true); //public A(boolean b) 안에 들어온거
	A a2 = new A(1);
	A a3 = new A("문자열"); //private임 외부에서는 보이지 않음
	
	
	//생성자
	public A(boolean b) {}
	A(int b) {} //같은 패키지 안에서는 사용 가능
	private A(String s) {} // 같은 패키지라도 사용 불가능 같은 클래스 안에서 사용가능

	
	
	
	//필드
	public int field1;
	int field2;
	private int field3;
	
	//생성자
	public A() { //같은 클래스 내부는 상관없음
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
		
	}
	
	//메소드
	public void method1() {}
	void method2() {}
	private void method3() {}
		
}
