package com.yedam.java.ch0702;

public class ChildTest {

	public static void main(String[] args) {
		Father father = new Father();//인스턴스 만들기
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();
		
		GrandFather gr = father; //최상위 클래스라서 내에 있는 인스턴스를 다 담아 줄 수 있음
		gr.method();
		
		gr = uncle;
		gr.method();
		
		gr = child;
		gr.method();
		
		gr = cousin;
		gr.method();
		
		
		//Father fa = uncle; //같은 조부에게 상속을 받은거지만 서로 영향은 없음
		//fa = child;
		//fa = cousin;
	
		System.out.println();
		Father fa = child;
		fa = child;
		fa.method(); //child 메소드가 실행됨
	
		Child ch = (Child)fa; //두개 관계가 있으니까 떙겨서 쓸 수 있음, 강제로 변환이 가능함
		//Cousin co = (Cousin)fa; //문법적으로는 문제 없지만 아빠랑은 사촌이 관계가 없다. 강제로 변환이 불가능함
		
		System.out.println();
		Uncle un = cousin;
		//un = father;
		//un = child;
		un.method(); //cousin의 메소드가 실행됨
	}

}
