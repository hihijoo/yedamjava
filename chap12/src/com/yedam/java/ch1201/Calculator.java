package com.yedam.java.ch1201;

public class Calculator {
	private int memory; //숫자를 단순히 저장
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) { // 여러 메모리에서 호출 가능
		this.memory = memory;
		try{
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : " + info.getName() +", memory : "+ this.memory);
	}

}
