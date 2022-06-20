package com.yedam.java.ch1201;

public class MultiThreadTest {
	public static void main(String[] args) {
		Thread main = Thread.currentThread(); //작업하는 스테드의 정보를 객체로 가져오는것
		System.out.println("메인 스레드 : "+ main.getName()); //메인 스레드는 이름이 main임
		//Runnable a = new ThreadA();
		//Thread thread = new Thread(a);
		
		ThreadB thread = new ThreadB();
		thread.setName("ThreadA"); //setname을 이용하면 원하는 이름으로 바꿀 수 있다.
		System.out.println("작업 스레드 : "+ thread.getName()); //원래는 thread-0으로 나옴
		thread.start();
		
		for (int i=1; i<=5; i++) {
			System.out.println(i + "번째 출력");
			try{
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
