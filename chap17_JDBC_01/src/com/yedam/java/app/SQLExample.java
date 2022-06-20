package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLExample {

	public static void main(String[] args) throws Exception {
	
		//1. JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB 서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		//3. CRUD 실행

		/******************INSERT********************/
		//-1. Statement or PrepareStatement 객체 생성하기
		String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(insert);
		
		//-2. SQL 구성 후 실행
		//물은표에 어떤 타입이 들어갈지 set에 정해주면됨, 첫번째 수는 물음표의 순서
		//(1이면 첫번쨰 물음표를 int 1000으로 대체하겠다.)
		pstmt.setInt(1, 1000); 
		pstmt.setString(2, "Kil-Dong");
		pstmt.setString(3, "Hong");
		pstmt.setString(4, "KdHong@google.com");
		pstmt.setString(5, "82.10.1234.1234");
		pstmt.setString(6, "21/11/05");
		pstmt.setString(7, "SA_REP"); 
		pstmt.setInt(8, 6000);
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10,149);
		pstmt.setInt(11,80);	
		
		//-3. 결과 출력
		int result = pstmt.executeUpdate();
		System.out.println("insert 결과 : " + result);
		
		/******************update********************/
		//-1. Statement or PrepareStatement 객체 생성하기
		//컬럼, 테이블명에는 ?사용 불가능, 실제 값을 넣고 싶은 위치에만 ?사용 가능
		String update = "UPDATE employees SET last_name = where employee_id =1000"; 
		pstmt = con.prepareStatement(update);
		
		//STATEMENT를 사용하면 밑에처럼 하나씩 지정해서 구성해야함
		//String temp = "UPDATE "+ TABLES + "SET "+ COLUMN +" = ";
		
		//-2. SQL 구성 후 실행 - 순서대로 꼭 하지 않아도 됨
		pstmt.setString(1,"Kang" );
		
		//-3. 결과 출력
		result = pstmt.executeUpdate();
		
		System.out.println("update 결과 : " + result);
		
	
		/******************SELECT********************/
        //-1. Statement or PreparedStatement 객체 생성하기
        String select = "SELECT * FROM employees ORDER BY employee_id";
        pstmt = con.prepareStatement(select);
        
        //-2. SQL 구성 후 실행
        ResultSet rs = pstmt.executeQuery();
        
        //-3. 결과 출력
        while(rs.next()) {
           String info = rs.getInt("employee_id") + " : "+ rs.getString("first_name");
           System.out.println(info);
        }


        /******************DELETE********************/
        //-1. Statement or PreparedStatement 객체 생성하기
        String delte  = "DELETE FROM employees WHERE employee_id = ?";
        pstmt = con.prepareStatement(delte);
        
        //-2. SQL 구성 후 실행
        pstmt.setInt(1, 1000);
     
        //-3. 결과 출력
        result = pstmt.executeUpdate();
        
        System.out.println("delete 결과 : "+result);
        
        
	     //4. 자원 해제하기
	     if(rs != null) rs.close();
	     if(pstmt != null) pstmt.close();
	     if(con != null) con.close();
     
  }

}