package com.yedam.java.ch0702;

public class ChildTest2 {

	public static void main(String[] args) {
		GrandFather gr = new Father(); //아빠로 인스턴스를 받음
		gr.method(); //gr했지만 father이 실행됨 (자식꺼 부터)
		//gr = new Uncle(); //삼촌이 끼어들었음
		
		System.out.println();
		if(gr instanceof Father) { //강제 형변환이 필요한 경우//아빠라는 인스턴스를 할배가 가지고 있는가// 할아버지 인스턴스가 아빠랑 같으면 실행하고
		Father fa = (Father) gr; //삼촌과 아빠사이는 관계가 없는데 왜 되는거지? gr에 삼촌이 담겨 있어 근데 아빠로 강제 형변환을 한거야
								// 자바는 그랜파와 사이에는 관계가 있다고 보기때문에 문법상으로는 오류가 없지만 실행은 오류가남
		fa.method(); //father가 시행됨
		fa.method2();
		} else { //같지 않다면 아닙니다 실행됨
			System.out.println("gr 변수가 가지고 있는 인스턴스는 Father가 아닙니다.");
		}
	}

}
