package com.yedam.java.ch1103;

public class WarpTest {

	public static void main(String[] args) {
		Integer obj1 = new Integer(100); //사용 안했으면 좋겠다
		Integer obj2 = Integer.valueOf("100");
		Integer obj3 = 100; //자동으로 박싱
		
		int val2 = obj2.intValue(); //언박싱 
		int val3 = obj3;
		
		int result = obj2 + val3;
		
		Integer object1 = 300;
		Integer object2 = 300;
		
		System.out.println("== 결과 : "+(object1 == object2));
		//언박싱 하면 내부에 있는 값 자체를 비교하는 것
		System.out.println("언박싱 후 == 결과 :"+ (object1.intValue() == object2.intValue()));
		System.out.println("equls() 결과 : " + object1.equals(object2));
	}

}
