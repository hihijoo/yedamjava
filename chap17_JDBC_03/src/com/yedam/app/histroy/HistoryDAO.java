package com.yedam.app.histroy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;
import com.yedam.app.product.Product;

public class HistoryDAO extends DAO {

	// 싱글톤
	private static HistoryDAO historyDAO = null;

	private HistoryDAO() {
	}

	public static HistoryDAO getInstance() {
		if (historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}

	// CRUD
	// 등록
	public void insert(History history) {
		try {
			connect();
			String sql = "INSERT INTO PRODUCT_HISTORY VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 수량
	public void update(History history) {

		try {
			connect();
			String sql = "UPDATE PRODUCT SET PRODUCT_AMOUNT =? WHERE product_id = ?";
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void delete(int productId) {

		try {
			connect();
			String sql = "delete from product_HISTORY WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 각 상품에 대한 입고(1)
	public int selectInAmount(int productId) {

		int result = 0;

		try {
			connect();
			// 입고된 전체량을 반환하고싶음
			String sql = "select sum(product_amount) sum from product_history where product_id=? and product_category = 1";
			// ?물음표 쓸때나 없을때 모다 pstmt로 사용가넝
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, productId); // product id를 셋팅해야함

			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 컬럼명으로 가져오거나 as 로 별칭을 정해서 가져오거나 위치 순서로 가져오는 방법
				result = rs.getInt("sum");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	// 단건조회 - 각 상품에 대한 출고(2)
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "select sum(product_amount) sum from product_history where product_id=? and product_category = 2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 컬럼명으로 가져오거나 as 로 별칭을 정해서 가져오거나 위치 순서로 가져오는 방법
				result = rs.getInt("sum");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	// 전체조회 - 전체 상품의 각 재고
	public Map selectAllAmount() {
		Map<Integer,Integer> list = new HashMap<>();
		try {
			connect();
			//각 제품에 따른 입고량과 출고량
			String sql = "SELECT product_id, product_category, sum(product_amount) AS amount FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//입고와 출고에 따른 각각의 목록
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			
			while(rs.next()) {
				int category = rs.getInt("product_category");
				if (category ==1) {
					inList.put(rs.getInt("product_id"),rs.getInt("amount"));
				} else {
					outList.put(rs.getInt("product_id"),rs.getInt("amount"));
				}
			}
			
			Set<Integer> keySet = inList.keySet();
			for(int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if(outAmount != null) {
					list.put(key, (inAmount - outAmount));//입고-출고= 재고
				}else {
					list.put(key, inAmount);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
		
	

}
