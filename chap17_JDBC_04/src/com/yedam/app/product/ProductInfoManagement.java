package com.yedam.app.product;

import com.yedam.app.common.Management;

public class ProductInfoManagement extends Management{

	//매니지먼트 클래스에 있는 필드와 dao를 끌어서 쓸거라서 필드가 없음
	
	//제품에 대한 정보를 등록, 수정, 삭제
	public ProductInfoManagement() {
		while(true) {
			
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo ==1) {
				//제품등록 정보
				insertProductInfo();
				
			}else if(menuNo ==2) {
				//제품정보수정
				updateProductInfo();
			}else if(menuNo ==3) {
				//제품정보 삭제
				deleteProductInfo();
			}else if(menuNo ==9) {
				//뒤로가기
				back();
				break;
			}else  {
				//입력오류
				showInputError();
			
			}
		}
	}
	
	@Override
	protected void menuPrint() {
		System.out.println("================================");
		System.out.println("1.제품등록 2.제품수정 3.제품삭제 9.뒤로가기");
		System.out.println("================================");
	}
	
	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}
	
	private void insertProductInfo() {
		//제품정보 입력
		Product product = inputAll();
		//db에 저장
		pDAO.insert(product);
		
		
	}
	
	private void deleteProductInfo() {
		//제품이름 입력
		String productName = inputName();
		
		//제품정보 검색
		
	
		//-1 products 테이블에서 정보
		Product product = pDAO.selectOne(productName);
		
		if(product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		//-2 입고내역에서 검색
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		
		//db에서 삭제
		if(isSelected) { //검색결과가 있을경우 true, 하지만 내가 삭제하는건 검색 결과가 없어야함
			System.out.println("거래내역이 존재합니다.");
		}else {
			pDAO.delete(product.getProductId());
		}
	}
	
	private void updateProductInfo() {
		//제품이름 입력
		String productName = inputName();
		
		//제품정보 검색
		Product product = pDAO.selectOne(productName);
		
		if(product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		
		//수정할 정보 입력
		product = inputUpdateInfo(product);
		
		
		//db 수정 -수정된 내용이 없더라도 무조건 업데이트된 정보가 들어가게함
		pDAO.updateInfo(product);
		
	}
	
	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품이름 > ");
		product.setProductName(sc.nextLine());
		System.out.println("제품가격 > ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}
	
	private String inputName() {
		System.out.println("제품이름 > ");
		return sc.nextLine();
	}
	
	private Product inputUpdateInfo(Product product) {
		System.out.println("기존 > "+product.getProductName());
		System.out.print("수정 (수정하지 않을 경우 0 입력) > ");
		String name = sc.nextLine();
		if(!name.equals("0")) {
			product.setProductName(name);
		}
		
		System.out.println("기존 > "+ product.getProductPrice());
		System.out.println("수정 (수정하지 않을 경우 -1 입력) > ");
		int price = Integer.parseInt(sc.nextLine());
		if(price>-1) {
			product.setProductPrice(price);
		}
		return product;
	}
	
	
}
