package com.yedam.java.ch1004;

public class Account {

	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withDraw(int money) throws BalanceInsufficientException { //반드시 throws를 적어야함 - 강제로 예외를 발생시켰기 때문에
		if(balance < money) {
			throw new BalanceInsufficientException("잔고부족 : " + (money - balance) + " 모자랍니다."); 
		} //강제로 예외를 발생시킨것 (throw를 붙여야함)
		
		balance -= money; //뒤에는 실행이 안됨
	}
	
}
