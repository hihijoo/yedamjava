package com.yedam.java.ch1502;

public class Util {
						//넘버(숫자)를 상속받는 클래스만 제네릭 타입으로 하겠다.
	public static <T extends Number> int compare(T t1, T t2) {
	double v1 = t1.doubleValue(); //number가 가지고 있는 메소드
	double v2 = t2.doubleValue();
	return Double.compare(v1,v2);
	}
}
