package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	
	//싱글톤
	private static ProductDAO productDAO = null;
	private ProductDAO(){}
	public static ProductDAO getInstance() {
		if(productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}
	
	
	//등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE) "+"VALUES (PRODUCTS_SEQ.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result >0 ) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정 -재고
	public void updateStock(Product product) {
		try {
			connect();				//문장 끝날때 마다 공백 신경쓰기
			String sql = "UPDATE products " + "SET product_stock = " +product.getProductStock()+ "where product_id = "+product.getProductId();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if (result>0) {
				System.out.println("재고가 수정되었습니다.");
			}else {
				System.out.println("재고가 정상적으로 수정되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}
	
	//수정 - 재고제외(이름, 가격에 대한 수정)
	public void updateInfo(Product product) {
		try {
			connect();											//콤마 중요
			String sql = "UPDATE products " + "SET product_name = ?, " +"product_price = ? "+"where product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				System.out.println("정상적으로 수정되었습니다.");
			}else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}
	
	
	//삭제
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM PRODUCTS "+ "WHERE PRODUCT_ID = " + productId;
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			if(result>0) {
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
	//단건조회 - 재고이름
	public Product selectOne(String productName) {
		Product product = null;
		try {
			connect();
			String sql = "select * from products " + "where product_name = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);

		rs = pstmt.executeQuery();
		
		//여기서 while문을 써도 한개만 나옴
		if(rs.next()) {
			product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductPrice(rs.getInt("product_price"));
			product.setProductStock(rs.getInt("product_stock"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return product;
	}
	
	//전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "select * from products order by product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				
				list.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	} 

}
