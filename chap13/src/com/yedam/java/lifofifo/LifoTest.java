package com.yedam.java.lifofifo;

import java.util.Stack;

public class LifoTest {
	//lifo - 후입선출(나중에 넣은 객체가 먼저 빠져나감)
	public static void main(String[] args) {
		Stack <Integer> box = new Stack<>();
		
		//push는 값을 넣는것
		box.push(100);
		box.push(50);
		box.push(500);
		box.push(10);
		
		while(!box.isEmpty()) {
			int value = box.pop();
			/*pop은 값을 꺼내는것 -> 넣을때랑 반대로 나옴~~ remove와 같이 쓰여진다고 생각하면 됨 
			 * 위에껄 없애야지 하나씩 꺼낼 수 있으니까??
			 * 한번 꺼내면 재사용이 불가능함
			 */
			System.out.println("\tbox 값" + box.size());
			System.out.println("꺼내온 값 : "+ value);
		}
		
	
		
	}

}
