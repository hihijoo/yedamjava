package com.yedam.app.deal;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class TakeOutGoodsDAO extends DAO {

	
	//싱글톤
	private static TakeOutGoodsDAO dao = null;
	private TakeOutGoodsDAO () {}
	public static TakeOutGoodsDAO getInstance() {
		if(dao == null) {
			dao = new TakeOutGoodsDAO();			
		}
		return dao;
	}
	
	//등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO TAKE_OUT_GOODS "+
						"(PRODUCT_ID, PRODUCT_AMOUNT) "+ "VALUES ( ?, ?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}
	
	//단건 조회 - 출고 내역 존재유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connect();
			String sql = "select count(*) as count " + 
						"from take_out_goods " + 
						"where product_id = "+ productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				if(rs.getInt("count")>0) {
					isSelected = true;
				}
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

		return isSelected;
	}
	

	
	
	
}
