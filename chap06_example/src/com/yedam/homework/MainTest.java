package com.yedam.homework;

import java.util.Scanner;

public class MainTest { //productsystem2

	public static void main(String[] args) {
	boolean run =true;
	Scanner sc = new Scanner(System.in);
	ProductSystem2 system = new ProductSystem2();
	
	while (run) {
		System.out.println("\n1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
		System.out.println("선택>");
		int selectNum = Integer.parseInt(sc.nextLine()); //메뉴에서 선택 할 수 있게 해줌,
														//nextline은 단독으로 사용해야함 
														//next는 ab엔터 하면 엔터 전까지만 읽어들이는것
														//nextline은 ab엔터 하면 엔터도 포함해서 읽어들이는 것
		if(selectNum == 1) {
				System.out.println("상품 수> ");
				int count = Integer.parseInt(sc.nextLine());
				system.setListSize(count);
		} else if (selectNum == 2) {
				System.out.print("상품이름> ");
				String name = sc.nextLine();
				System.out.print("상품가격> ");
				int price = Integer.parseInt(sc.nextLine());
				system.putProduct(name, price);
		} else if (selectNum == 3 ) {
				System.out.println("제품별 가격> ");
				system.printList();
		} else if (selectNum == 4) {
				Product maxInfo = system.getMaxPriceInfo();
				System.out.println("최고 가격 제품 : " + maxInfo.getName()); 
				System.out.println("최고 가격을 제외한 총합 : " +system.getTotalPrice());
		}else if (selectNum == 5) {
				run = false;
				System.out.println("\n프로그램을 종료합니다.");
				
	}
	}

}
}
