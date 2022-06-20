package com.yedam.java.home;

import java.util.Scanner;

public class BookProgram implements Program {

	//private BookAccess dao = BookRepo.getInstance();
	private Scanner sc = new Scanner(System.in);

	@Override
	//메뉴
	public void menuPrint() {
		System.out.println("===============================================================");
		System.out.println("1.도서정보 입력 | 2.전체조회 | 3.검색 | 4.수정 | 5.삭제 | 6.분석 | 7.종료");
		System.out.println("===============================================================");
	}

	@Override
	public void inputInfo(BookAccess access) {
		//사용자가 정보를 입력
		Book info = inputAll();
		//저장소에 등록
		access.insert(info);
		
	}
	
	private Book inputAll() {
		System.out.print("도서 이름>");
		String name = sc.nextLine();
		System.out.print("가격>");
		int price = Integer.parseInt(sc.nextLine());
		
		return new Book(name, price);
		}
	

	@Override
	//전체출력
	public void pirntAllInfo(BookAccess access) {
		//저장소에서 데이터를 가져옴
		Book[] list = access.selectAll();
		//데이터를 전체 출력
		for(Book data : list) { //list안에 null이 없어야함
			data.showInfo();
		}
	}

	@Override
	//검색 조회
	public void printInfo(BookAccess access) {
		//검색 조건 입력
		int keyword = inputOne();
		//저장소에서 검색 
		Book data = access.selectOne(keyword);
		//출력
		data.showInfo();
	}
	
	private int inputOne(){
		System.out.print("검색 ISBN>");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	//갱신
	public void printUpdate(BookAccess access) {
		System.out.print("수정할 ISBN을 입력하세요");
		int isbn = Integer.parseInt(sc.nextLine());
		Book info = access.selectOne(isbn);
		
		System.out.print("수정할 가격을 입력하세요");
		int price = Integer.parseInt(sc.nextLine());
		info.setPrice(price);
	} 
	
	
	@Override
	//삭제
	public void printDelete(BookAccess access) {
		System.out.print("삭제할 ISBN을 입력하세요");
		int isbn = Integer.parseInt(sc.nextLine());
		
		access.delete(isbn);
	}
	 
	
	@Override
	//분석
	public void printRepo(BookAccess access) {
		
		//최고 가격 책
		System.out.print("최고 가격의 도서>");
		Book maxInfo = selectMaxPrice(access);
		maxInfo.showInfo();
		//최저 가격 책
		System.out.print("최저 가격의 도서>");
		Book minInfo = selectMinPrice(access);
		minInfo.showInfo();
		//평균
		System.out.print("최고,최저 가격을 제외한 평균>");
		double avgResult = selectAvg(access);
		System.out.printf("%.2f\n",avgResult);
	}
	
	//최고 가격
	private Book selectMaxPrice(BookAccess access) {
		Book[] list = access.selectAll();
				
		Book maxInfo = list[0];
		for(int i=1; i< list.length; i++) {
			if(maxInfo.getPrice() < list[i].getPrice()) {
				maxInfo = list[i];
			}
		}
		
		/* Book maxInfo = list[0];
		for(Book data : list) {
		if(maxInfo.getPrice() < data.getPrice())
			maxInfo = data
			*/
		return maxInfo;
	}

	
	//최저 가격
	private Book selectMinPrice(BookAccess access) {
		Book[] list = access.selectAll();
		
		Book minInfo = list[0];
		for(int i=1; i< list.length; i++) {
			if(minInfo.getPrice() > list[i].getPrice()) {
				minInfo = list[i];
			}
		}
		return minInfo;
	}
	
	//평균(최고 가격,최저 가격 제외) 
	private double selectAvg(BookAccess access) {
		Book[] list = access.selectAll();
		
		int sum =0;
		for (Book info : list) { //list가 북 인포에 들어가서 sum이 실행되고 다시 list로 감
			sum += info.getPrice();
		}
		
		double all = 0.0;
		double avg = 0.0;
		all = sum - (selectMaxPrice(access).getPrice()+ selectMinPrice(access).getPrice());
		avg = all/(list.length-2);
		
		return avg;
	
	}
	
	
	
	/*
	 * private calcAvgInfo() {
	 * Book maxInfo = selectMaxInfo();
	 * Book minInfo = selectMinInfo();
	 * 
	 * Book[] list = dao.selectAll();
	 * int sum =0;
	 * for(Book data : list) {
	 * if(data.getPrice() > minInfo.getPrice() && data.getPirce() < maxInfo.getPrice()) {
	 * 조건에 만족하는 경우의 총합
	 * sum += data.getPrice();
	 * 조건에 만족하는 경우의 정보를 출력
	 * data.showInfo();
	 * }
	 * }
	 * 
	 *double avg = (double)sum / (list.length - 2);
	 *System.out.print("최고가격과 최저가격을 제외한 평균");
	 *System.out.prinf("%.2f\n",avg);
	 */
	
}
	
	