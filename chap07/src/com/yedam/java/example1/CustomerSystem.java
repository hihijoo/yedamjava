package com.yedam.java.example1;

import java.util.Scanner;

public class CustomerSystem {

	//필드
	private Repo repo = new Repo();  //내가 이용해야 하는 데이터
	private Scanner sc = new Scanner(System.in);
	
	//생성자
	public CustomerSystem( ) {
		while(true) { //생성자에서 돌릴거임  main에서는 new연산자만 써도 돌아감, true라서 무한 루프 돌아감
			
			//메뉴 출력
			menuPrint();
			//메뉴 선택
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//메뉴1 - 회원가입 //스위치 사용 불가능
				singUp();
			} else if (menuNo == 2) {
				//메뉴2 - 회원 정보
				myPage();
			} else if  (menuNo ==3) {
				//메뉴3 - 결제시 금액
				payInfo();
			} else if (menuNo == 4) {
				//메뉴 4 - 종료
				exit();
				break;
			}
			
		}
	}
	//메소드
	
	void menuPrint () {
		System.out.println("=========================================");
		System.out.println("1.회원가입 | 2.회원정보 | 3. 결제금액 | 4. 종료 ");
		System.out.println("=========================================");
	}
	
	int menuSelect() {
		System.out.println("메뉴> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	void singUp() {
		//회원 정보 입력
		Customer info = inputAll();
		//가입
		repo.insert(info); //repo에서 가져옴
	}
	
	  Customer inputAll() { //회원정보 입력
	    
		//회원 기본 정보 입력
		System.out.println("아이디> ");
		int Id = Integer.parseInt(sc.nextLine());
		System.out.println("이름> ");
		String name = sc.nextLine();
				
		
		//회원 등급 선택
		int selected = selectGrade(); //등급에 따라서 인스턴스를 만들어서 반환해줘
		Customer customer = null;
		switch(selected) {
		case 1: 
			customer = new Customer(Id, name);
			break;
		case 2:
			customer = new Gold(Id, name);
			break;
		case 3:
			customer = new Vip (Id, name, "이한나");
			break;
		}
		return customer;
	} 

	
	int selectGrade() {
		System.out.println("1.SILVER | 2. GOLD | 3.VIP");
		System.out.println("--------------------------");
		return Integer.parseInt(sc.nextLine());
	}
	
	void myPage() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		System.out.println(info.showInfo());
	}

	void payInfo() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		
		System.out.println("구매금액> ");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calcPrice(price);
		System.out.println("결제 금액 : " + pay);

	}

	int inputOne()  {
		System.out.println("고객 아이디> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	void exit () {
		System.out.println("프로그램 종료");
	}

}
