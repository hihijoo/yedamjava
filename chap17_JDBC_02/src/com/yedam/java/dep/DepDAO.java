package com.yedam.java.dep;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.yedam.java.emp.Employee;

public class DepDAO {

	
	//싱글톤
	private static DepDAO depDAO = null;
	private DepDAO() {}
	
	public static DepDAO getInstanc() {
		if(depDAO == null) {
			depDAO = new DepDAO();
			
		}
	return depDAO;
	}
	
	//데이터 베이스와 연결하는데 필요한 정보
	String jdbcDriver;
	String oracleUrl;
	String connectedId;
	String connectedPwd;
	
	//데이터 베이스를 사용하는데 필요한 정보 - 각 메소드에서 공통적으로 사용하는 필드 - 현재 아무 값도 안들어가있는 상태
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
		//메소드 실행해서 값을 넣을 예정
		public void connect() {
			dbConfig();
			
			try {
				
				//1. JDBC Driver 로딩
				Class.forName(jdbcDriver);
				
				//2.DB접속
				conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
			}catch(ClassNotFoundException e) {
				System.out.println("JDBC Driver 로딩 실패");
			}catch (SQLException e) {
				System.out.println("DB 접속 실패");
			}
		}

		private void dbConfig() {
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
	
	//3. CRUD 실행
		//1.전체 조회 - 몇개가 들어올지 모르기떄문에 lsit형태로 써야함 배열못씀
		public List<Department> selectAll(){
			List<Department> list = new ArrayList<>(); //여기에 정보가 저장이 되어있음
			try {
				connect(); //연결하고
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM departments ORDER BY department_id ");
				while(rs.next()) { //값을 넘겨줄뿐 연산은 하지 않음 - 전체조횐까 while 문을 써야함
					Department dep = new Department();
					dep.setDepartmentId(rs.getInt("department_id"));
					dep.setDepartmentName(rs.getString("department_name"));
					dep.setLocationId(rs.getInt("location_id"));
					dep.setManagerId(rs.getInt("manager_id"));
					
					list.add(dep);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect(); //끊고!!!!!!
			}
			return list; //넘겨줘야함
		}
		
		//2. 단건 조회
		public Department selectOne(int departmentId) {
			Department dep = null;
			try {
				//연결
				connect();
				String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =" + departmentId;
				stmt = conn.createStatement();
				rs=stmt.executeQuery(sql);
				
				//단건은 하나만 반환되면 되니까 while 문이 필요없음
				if(rs.next()) {
					dep = new Department();
					dep.setDepartmentId(rs.getInt("department_id"));
					dep.setDepartmentName(rs.getString("department_name"));
					dep.setLocationId(rs.getInt("location_id"));
					dep.setManagerId(rs.getInt("manager_id"));
				}
				
			} catch(SQLException e ) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return dep;
		}
		
		//3. 등록
		public void insert (Department dep) {
			try {
				//연결
				connect();
				String sql = "INSERT INTO departments VALUES (?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dep.getDepartmentId());
				pstmt.setString(2, dep.getDepartmentName());
				pstmt.setInt(4, dep.getLocationId());
				pstmt.setInt(3, dep.getManagerId());
				
				//int를 반환해야함, 숫자가 의미하는건 몇개를 업데이트 했냐
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("등록이 완료되었습니다.");
				} else {
					System.out.println("등록이 되지 않았습니다.");
				}
				
				System.out.println(result+ "건이 완료되었습니다."); 
				
				
			}catch(SQLException e ) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
		}
			
		//4. 수정
		public void update(Department dep) {
			try {
				connect();
				String sql = "UPDATE departments SET Department_Name = ? where department_id = ?";
				pstmt = conn.prepareStatement(sql);	
				pstmt.setString(1, dep.getDepartmentName());
				pstmt.setInt(2, dep.getDepartmentId()); 
				
				int result = pstmt.executeUpdate(); //값이 나오게 하는것 꼭 필요함
				
				if(result >0) {
					System.out.println("수정이 완료되었습니다.");
				}else {
					System.out.println("수정이 완료되지 않았습니다.");
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					disconnect();
				}
		}
		
		//5. 삭제
		public void delete(int departmentId) {
			try {
				connect();
				String sql = "DELETE FROM departments WHERE department_id =" + departmentId;
				stmt = conn.createStatement();
				int result = stmt.executeUpdate(sql);
				
				if(result >0 ) {
					System.out.println("정상적으로 삭제되었습니다.");
				}else {
					System.out.println("정상적으로 삭제되지 않았습니다.");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
		}
	
		
		
}
