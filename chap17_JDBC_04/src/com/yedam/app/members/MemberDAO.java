package com.yedam.app.members;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class MemberDAO extends DAO {
	
	//싱글톤
	private static MemberDAO dao = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	//CRUD
	public Member selectOne(Member member) {
		Member loginInfo = null;
		try {
			connect();		//아이디때문에 로그인이 안되는지 비밀번호 때문에 로그인이 안되는지 구분하기 위해서 나눔
			String sql = "select * from members where member_id = '" + member.getMemberId()+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) { //실행되면 아이디는 존재함	
								
				if(rs.getString("member_password").equals(member.getMemberPassword())) {
					//비밀번호도 같은지 확인해야함
					// 로그인 성공
					loginInfo = new Member();
					loginInfo.setMemberId(rs.getString("member_id"));
					loginInfo.setMemberPassword(rs.getString("member_password"));
					loginInfo.setMemberRole(rs.getInt("member_role"));
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				//아이디가 존재하지 않음
				System.out.println("아이디가 존재하지 않습니다.");
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return loginInfo;
	}
}
