package com.yedam.app.common; //공통적으로 사용할것은 여기에

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO { //이건 싱글톤으로 만들지 않을거임- 상속받는 자식 클래스로 만들것
	
	//데이터 베이스와 연결하는데 필요한 정보 - dao 클래스에서만 사용 할 수 있도록 막음
		private String jdbcDriver;
		private String oracleUrl;
		private String connectedId;
		private String connectedPwd;
		
		//데이터 베이스를 사용하는데 필요한 정보 - 각 메소드에서 공통적으로 사용하는 필드 -이건 넘겨줘야하니까 protected로 만듦
		protected Connection conn;
		protected Statement stmt;
		protected PreparedStatement pstmt;
		protected ResultSet rs;

		//메소드 실행해서 값을 넣을거임
		public void connect() { //db에 연결을 해야함
			dbConfig(); //연결할때마다 계속 실행되니까 낭비임
			
			try {
		//1.JDBC Driver 로딩 - 너 어떤 드라이브 쓸거임?
		Class.forName(jdbcDriver);	//oracle.jdbc.driver.OracleDriver - 윤철씨는 이거로 함 
		
		//2. DB 서버 접속
		conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
			}catch(ClassNotFoundException e) {
				System.out.println("JDBC Driver 로딩 실패");
			}catch (SQLException e) {
				System.out.println("DB 접속 실패");
			}
		}
		
		private void dbConfig() { // 파일에 저장된것을 가져옴, 파일값만 바꾸면 되니까 편리함
			String resource = "config/db.properties";
			Properties properties = new Properties();
			
			try {                //class 정보를 가져오는것, 지금실행되는 클래스의 정보, 접근위치 넘겨 자원찾기, 경로를 가져옴
				String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
				properties.load(new FileInputStream(filePath)); //파일 읽어들이는 방식
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			//map에 key과 value 의 형태
			jdbcDriver = properties.getProperty("driver");
			oracleUrl = properties.getProperty("url");
			connectedId = properties.getProperty("id");
			connectedPwd = properties.getProperty("password");
		}
		
		//4. 자원 해제
		public void disconnect() {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
}
