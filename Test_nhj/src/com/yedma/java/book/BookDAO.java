package com.yedma.java.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.java.common.DAO;

public class BookDAO extends DAO{

	
	//싱글톤
	private static BookDAO bookDAO = null;
	private BookDAO() {}
	public static BookDAO getInstance() {
		if(bookDAO == null) {
			bookDAO = new BookDAO();
		}
		return bookDAO;
		
	}
	
	//1. 전체조회
	public List<Book> selectAll () {
		List<Book> list = new ArrayList<Book> ();
		
		try {
			connect();
			String sql = "select * from books order by book_name";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Book bo = new Book();
				bo.setBookName(rs.getString("book_name"));
				bo.setBookWriter(rs.getString("book_writer"));
				bo.setBookContent(rs.getString("book_content"));
				bo.setBookRental(rs.getInt("book_rental"));
				list.add(bo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	
	
	//2. 단건조회 - 책이름
	public Book selectBookName (String bookName) {
		Book bo = null;
		
		try {
			connect();
			String sql = "select * from books where book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bookName);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bo = new Book();
				bo.setBookName(rs.getString("book_name"));
				bo.setBookWriter(rs.getString("book_writer"));
				bo.setBookContent(rs.getString("book_content"));
				bo.setBookRental(rs.getInt("book_rental"));

			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bo;
	}
	
	//3. 내용검색 -자바
	public List<Book> selectContent (String bookName) {
		List<Book>list = new ArrayList<>();
		
		try {
			connect();
			String sql = "select * from books where book_content like '%" + bookName + "%' order by book_name";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
		while (rs.next()) {
				Book bo = new Book();
				bo.setBookName(rs.getString("book_name"));
				bo.setBookWriter(rs.getString("book_writer"));
				bo.setBookContent(rs.getString("book_content"));
				bo.setBookRental(rs.getInt("book_rental"));
			
				list.add(bo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//4. 대여가능
	public List<Book> selectBorrow () {
		List<Book>list = new ArrayList<>();
		try {
			connect();
			String sql = "select * from books where book_rental = 0 order by book_name";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Book bo = new Book();
				bo.setBookName(rs.getString("book_name"));
				bo.setBookWriter(rs.getString("book_writer"));
				bo.setBookContent(rs.getString("book_content"));
				bo.setBookRental(rs.getInt("book_rental"));
			
				list.add(bo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//5. 책 대여
	// 인자로 책 제목을 받고
	// string 셋팅 -> update문을 돌림 -> book_rental -> 1로셋팅
	// int result 업데이트 됐는지 확인하기
	public void borrowBook(String bookName) {
		try {
			connect();
			String sql = "update books set book_rental = ? where book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,1);
			pstmt.setString(2, bookName);
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println("정상적으로 대여되었습니다.");
			}else {
				System.out.println("정상적으로 대여되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}

	
	//6. 책 반납
	//인자로 책 제목을 받고
	// string 셋팅 -> update문을 돌림 -> book_rental -> 0으셋팅
	// int result 업데이트 됐는지 확인하기 
	public void returnBook(String bookName) {
		try {
			connect();
			String sql = "update books set book_rental = ? where book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,0);
			pstmt.setString(2, bookName);
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println("정상적으로 반납되었습니다.");
			}else {
				System.out.println("정상적으로 반납되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}
	
	//7. 책등록
	public void insert(Book book) {
		try {
			connect();
			String sql = "INSERT INTO books(book_name, book_writer, book_content) VALUES (?, ?, ?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("정상적으로 등록되었습니다.");
			}else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//9. 종료
	
	
}
