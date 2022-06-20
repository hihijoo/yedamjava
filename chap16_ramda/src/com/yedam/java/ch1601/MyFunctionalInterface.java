package com.yedam.java.ch1601;

// 람다식 인터페이스
@FunctionalInterface // 한개 이상의 메소드를 선언 할 수 없게 만듦, 람다식으로 만들 가능성이 있다.
//람다식 인터페이스
public interface MyFunctionalInterface {

	
	/*반드시 하나의 메소드만 포함하고 있어야 한다. 
	여러개 만드는건 문제가 없지만 실제로 구현할때 오류가 생김(위에 @ 만들어 놓으면 두개만들때 오류 뜨게함)
	*/
	
	public void method();
	
	
}
