package com.yedam.homework;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		
		
	boolean run = true;
	Scanner sc = new Scanner(System.in);
	ProductSystem pro = new ProductSystem();

	while (run) {
		System.out.println("\n1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
		System.out.println("선택>");
		int selectNum = Integer.parseInt(sc.nextLine());
	
		if(selectNum == 1) {
			System.out.println("상품 수> ");
			int count = Integer.parseInt(sc.nextLine());
			pro.setListSize(count);
		} else if (selectNum == 2) {
			System.out.println("상품 및 가격입력> ");
			String name = sc.nextLine();
			int price = Integer.parseInt(sc.nextLine());
			pro.putProduct(name,price);
		} else if (selectNum == 3 ) {
			System.out.println("제품별 가격> ");
			pro.printList();
		} else if (selectNum == 4) {
			System.out.println("분석> ");
			pro.printTotal();
		}else if (selectNum == 5) {
			run = false;
			System.out.println("종료합니다.");
	}
	}

}
}
