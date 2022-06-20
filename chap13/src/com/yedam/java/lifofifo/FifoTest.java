package com.yedam.java.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {
	//fifo - 선입선출(먼저 넣은 객체가 먼저 빠져나가는 구조)
	public static void main(String[] args) {
		//linkedList - 인접 참조를 링크, 특정 인덱스의 객체를 제거되면 앞뒤 링크만 변경되고 나머지 링크는 변경x
	Queue<Integer> que = new LinkedList<>();
	
		//offer 값을 넣음
		que.offer(100);
		que.offer(50);
		que.offer(500);
		que.offer(10);
		
		while(!que.isEmpty()) {
			int value = que.poll();
			/*poll값을 꺼내는 것
			 * 입력한 순서대로 값이 나옴
			 */
			System.out.println("\tQueue 수 : " +que.size());
			System.out.println("꺼내온 값 : "+ value);
		}
		

	}

}
