package com.yedam.java.question;

public interface Payment {

	//필드
	public static final double OFFLINE_PAYMENT_RATIO =0;
	public static final double ONLINE_PAYMENT_RATIO = 0;
	public static final double SIMPLE_PAYMENT_RATIO = 0;
	
	//메소드
	public abstract int offline(int price);
	public abstract int online(int price);
	public abstract int simple(int price);
	public abstract void showCardInfo();
	
}
