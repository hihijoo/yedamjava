package com.yedam.java.ch0606.package2;

import com.yedam.java.ch0606.package1.A;

public class C {
	//필드
		A a1= new A(true);
		A a2 = new A(1); 
		A a3 = new A("문자열");

		//생성자
				public C() { //같은 클래스 내부는 상관없음
					A a = new A();
					
					a.field1 = 1;
					a.field2 = 1; // 디폴트는 다른 패키지 안에서는 사용이 불가능
					a.field3 = 1; //프라이빗이라소 b라는 클래스에서는 애를 사용 할 수 없음
					
					a.method1();
					a.method2();
					a.method3();
					
				}
		
}
