package com.yedam.java.ch1502;

public class MainTest {

	public static void main(String[] args) {
		
		//util이 숫자만 상속 받기 아무리 string으로 강제 형변환 해줘도 사용 할 수 없음
		//int result1 = Util.<String>compare("홍","김");
		
		int result2 = Util.compare(1, 10);
		
		int result3 = Util.compare(0.5, 5.9); ///실수도 사용 가능

	}

}
