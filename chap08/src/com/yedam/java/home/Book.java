package com.yedam.java.home;

public class Book { //vo클래스? dto-정보를 저장하는 용도 (필드와 get,set만 가짐)
		
	
	//필드
	private int isbn; //도서번호
	private String name; //책 제목
	private int price; //가격
	
	private static int serialNum = 1000; 
	
	
	//생성자  

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
		this.isbn = serialNum++;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setISBN(int isbn) {
		this.isbn = isbn;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("ISBN : "+ isbn + ", 제목 : "+name+ ", 가격 : "+price);
		//String info = "ISBN : " +this.isbn + ",제목 : " + this.name + ",가격 : " +this.price
		//System.out.println(info);
	}
	
	
	
	
	
}
