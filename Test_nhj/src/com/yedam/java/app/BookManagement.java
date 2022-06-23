package com.yedam.java.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.yedma.java.book.Book;
import com.yedma.java.book.BookDAO;

public class BookManagement {

	private Scanner sc = new Scanner(System.in);
	private BookDAO bDAO = BookDAO.getInstance();
	
	public BookManagement () {
		while(true) {
			//메뉴 출력
			menuPrint();
			//메뉴 입력
			int menuNo = selectMenu();
			
			//각 기능별 실행
			if(menuNo ==1) {
				//1.전체조회
				allBookStock();
			} else if(menuNo ==2) {
				//2.단건조회
				selectName();
			}else if(menuNo ==3) {
				//3.내용검색
				selectContent();
			}else if(menuNo ==4) {
				//4.대여가능
				availableBook();
			}else if(menuNo ==5) {
				//5. 책대여
				bookOut();
			}else if(menuNo ==6) {
				//6. 책 반납
				bookIn();
			}else if(menuNo ==7) {
				//7. 책 등록
				insertBook();
			}else if(menuNo ==9) {
				//종료
				exit();
				break;
			} else {
				showInputError();
				break;
			}
		}
	}
	
	private void menuPrint() {
		System.out.println("=============================================================");
		System.out.println("1.전체조회 2.단건조회 3.내용검색 4.대여가능 5.책 대여 6.책 반납 7.책 등록 9.종료");
		System.out.println("=============================================================");
	}
	
	//전체조회
	private void allBookStock() {
		List<Book> list = bDAO.selectAll();
		
		for(Book book : list) {
			System.out.println(book);
		}
	}
	//메뉴 선택
	private int selectMenu() {
		System.out.print("메뉴선택>");
		
		int menu = 0;
		
		try {
			menu = Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		}return menu;
	}
	
	
	
	//도서 조회 - 책이름
	private void selectName() {
		String bookName = inputName();
		Book book = bDAO.selectBookName(bookName);
		
		if(book ==null) {
			System.out.println("등록된 책이 아닙니다.");
			return;
		}
		System.out.println(book);
	}
	
	private String inputName() {
		System.out.print("책제목>");
		return sc.nextLine();
	}
	
	//내용검색
	private void selectContent() {
		//도서 내용 검색
		String bookContent = inputContent();
		
		//해당 도서의 출력
		List<Book> list = new ArrayList<>();
		list = bDAO.selectContent(bookContent);
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	

	private String inputContent() {
		System.out.print("검색내용>");
		return sc.nextLine();
		
	}
	
	//4.대여가능
	private void availableBook() {
		List<Book> list = bDAO.selectBorrow();
		
		for (Book book : list) {
			System.out.println(book);
		}
 		
	}
	
	//5.책대여
	private void bookOut() {
		System.out.println("대여할 책 이름을 입력하세요.");
		String bookName = sc.nextLine();
		
		Book book = bDAO.selectBookName(bookName);
		
		if(book ==null) {
			System.out.println("등록된 책이 아닙니다.");
			return;
		}
		
		if (book.getBookRental() == 1) {
			System.out.println("대여할 수 없습니다.");
			return;
		}
	
		bDAO.borrowBook(bookName);
	
	}
	
	//6.책반납
		private void bookIn() {
			System.out.println("반납할 책 이름을 입력하세요.");
			String bookName = sc.nextLine();
			
			Book book = bDAO.selectBookName(bookName);
			
			if(book ==null) {
				System.out.println("등록된 책이 아닙니다.");
				return;
			}
			
			if (book.getBookRental() == 0) {
				System.out.println("반납할 수 없습니다.");
				return;
			}
		
			bDAO.returnBook(bookName);
			
		}
	//책 등록
	private void insertBook() {
		//도서 정보 입력
		Book book = inputAll();
		
		//DB에 저장
		bDAO.insert(book);
	
	}
	private Book inputAll() {
		Book book = new Book();
		System.out.print("책제목 > ");
		book.setBookName(sc.nextLine());
		System.out.print("저자명 > ");
		book.setBookWriter(sc.nextLine());
		System.out.print("내용 > ");
		book.setBookContent(sc.nextLine());
	
		return book;
		
	}
	
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	
	private void showInputError() {
		System.out.println("메뉴를 참고하여 입력해주시기 바랍니다.");
	}
	
	}

