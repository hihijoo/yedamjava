package com.yedam.java.ch1004;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예급액 : " + account.getBalance());
		
		try {
			account.withDraw(30000);
		} catch (BalanceInsufficientException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		

	}

}
