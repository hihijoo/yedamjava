package com.yedam.java.ch1202;

public class PrintThread extends Thread {
	
	@Override
	public void run() {
	
		/*
		//interrupt - > 작업 중 일시적인 추가작업이 필요한 경우
		// * 수를 입력해서 종료 시켜도 무한 반복이 됨
		while(true) {
			System.out.println("실행중");
			try {
			Thread.sleep(1000); 
			} catch(InterruptedException e) { 
				System.out.println("Interrupt method 실행");
			}
		*/
		
		
		// interrupt -> 작업 스레드를 종료시킬 경우
		try {
			while(true) {
				System.out.println("실행중");
				Thread.sleep(1000); //잠들게 만들고
			} 
		} catch(InterruptedException e) { //깨워야함
			System.out.println("Interrupt method 실행");
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	}
	}

