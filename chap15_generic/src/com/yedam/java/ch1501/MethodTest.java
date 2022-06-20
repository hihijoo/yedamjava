package com.yedam.java.ch1501;

public class MethodTest {

	public static void main(String[] args) {
		BoxA<Integer> intBox = Util.<Integer>boxing(100);

		Pair<Integer,String> p1 = new Pair<>(1,"사과");
		Pair<Integer,String> p2 = new Pair<>(1,"애플");		
		
		//타입을 지금은 유추하고 있지만 경우에 따라서는 적어줘야함
		boolean result1 = Util.compare(p1, p2);
		if(result1) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않습니다.");
		}
		
		//
		Util.<String, Integer>printInfo("홍길동");
	}

}
