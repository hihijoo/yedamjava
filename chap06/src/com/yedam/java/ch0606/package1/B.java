package com.yedam.java.ch0606.package1;

public class B {

	//필드
		A a1= new A(true);
		A a2 = new A(1);
		A a3 = new A("문자열"); //그래서 B에서 보이지 않음

		
		//생성자
		public B() { //같은 클래스 내부는 상관없음
			A a = new A();
			
			a.field1 = 1;
			a.field2 = 1;
			a.field3 = 1; //프라이빗이라소 b라는 클래스에서는 애를 사용 할 수 없음
			
			a.method1();
			a.method2();
			a.method3();
			
		}
}
