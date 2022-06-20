package com.yedam.java.ch1601;

public class RamdaTest {

	public static void main(String[] args) {
		//매개변수도 리턴타입도 없는 람다식
		MyFunInterfaceA fa = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fa.method();
		
		fa = () -> {System.out.println("method call2"); };
		fa.method();
		
		//실행 부분이 한줄일 경우 이렇게도 사용 가능
		fa = () -> System.out.println("method call3");
		fa.method();

		System.out.println();
		
		//매개변수가 있고 리턴타입이 없는 람다식
		MyFunInterfaceB fb = (int x) -> {
			int result = x*5;
			System.out.println(result);
		};
		fb.method(5);
		
		// int타입을 선언해놨기 때문에 바로 x라는 변수를 사용해도 알아서 int로 적용됨
		fb = (x) -> {System.out.println(x*5);};
		fb.method(7);
		
		fb = x -> System.out.println(x*5);
		fb.method(10);
		
		
		//매개변수가 있고 리턴타입이 있는 경우
		MyFunInterfaceC fc = (int x, int y) -> {
			int result = x+y;
			return result;
		};
		fc.method(1, 2);
		System.out.println(fc.method(1, 2));
		
		fc = (x,y) -> {return x+y;};
		System.out.println(fc.method(1, 5));
		
		fc = (x,y) -> x+y;
		System.out.println(fc.method(6, 5));
		
		
		System.out.println();
		
		
		fc = (x,y) -> Math.max(x, y);
		fc = (x,y) -> {
			
			//int result = Math.max(x,y);
			//return result;
			return Math.max(x, y);
		
		};
		System.out.println(fc.method(20, 12)); //왜 이건 값이 안나오지 내가 임으로 적어 넣은것
	
		
		fc = (x,y) -> Math.max(x, y);
		System.out.println(fc.method(10, 12));
		
		
		
		int val1 = 10;
		int val2 = 20;
		
		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
		};
		
		//val1 = 100; //외부에서 값을 넣을 수 없음
		fa.method();
	
	}
}


