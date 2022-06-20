package com.yedam.java.home;

public interface BookAccess {

	//사용방법
	
		//등록
		public void insert(Book book);
		//void insert(Book book);
		 
		//수정
		public void update(Book book) ;
		
		//삭제
		public void delete(int isbn);
		
		//전체조회
		public Book[] selectAll();
		//Book[] selectAll();
		
		//단건조회
		public Book selectOne(int isbn);
	
	
}
