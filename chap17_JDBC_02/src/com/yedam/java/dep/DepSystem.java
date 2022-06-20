package com.yedam.java.dep;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp.Employee;

public class DepSystem {

	private DepDAO dao = DepDAO.getInstanc();
	private Scanner sc = new Scanner(System.in);
	
	public DepSystem() {
		while (true) {
			//메뉴출력
			menuPrint();
			//메뉴입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo ==1) {
				//등록
				insertDepartment();
			}else if(menuNo ==2 ) {
				//수정
				updateDepartment();
			}else if(menuNo ==3 ) {
				//삭제
				deleteDepartment();
			}else if(menuNo ==4 ) {
				//부서조회(단건조회)
				selectDepartment();
			}else if(menuNo ==5 ) {
				//전체조회
				selectAllDepartment();
			}else if(menuNo ==9 ) {
				//종료
				exit();
				break;
			}else {
				inputError();
			}
		}
	}
	
	//생성자 안에서만 작동하도록 구성
	private void menuPrint() {
		System.out.println("=======================================");
		System.out.println("1.등록 2.수정 3.삭제 4.부서조회 5.전체조회 9.종료");
		System.out.println("=======================================");
	}
	
	private int selectMenu() {
		int menu = 0;
		
		try {
			menu = Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		}return menu;
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void inputError() {
		System.out.println("메뉴에 맞게 입력해주세요.");
	}
	
	private void insertDepartment() {
		//사원정보 입력
		Department dep = inputAll();
		//db 전달
		dao.insert(dep);
	}
	
	private void updateDepartment() {
		//수정하는 정보
		Department dep = inputUpdateInfo();
		//db 전달
		dao.update(dep);
	}
	
	private void deleteDepartment() {
		//삭제하는 정보
		int departmentId = inputDepartmentId();
		
		//DB에 전달
		dao.delete(departmentId);
	}
	
	private void selectDepartment() {
		//사원 번호 입력
		int DepartmentId = inputDepartmentId();
		//db 검색
		Department dep = dao.selectOne(DepartmentId);
		
		//결과 출력
		if(dep != null) {
			System.out.println(dep);
		}else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}
	
	private void selectAllDepartment() {
		List<Department> list = dao.selectAll();
		
		for(Department dep : list) {
			System.out.println(dep);
		}
	}
	
	private Department inputAll() {
		Department dep = new Department();
		System.out.println("부서번호>>");
		dep.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서이름>>");
		dep.setDepartmentName(sc.nextLine());
		System.out.println("상사번호>>");
		dep.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.println("지역번호>>");
		dep.setLocationId(Integer.parseInt(sc.nextLine()));

		return dep;
	}
	
	
	private Department inputUpdateInfo() {
		Department dep = new Department();
		System.out.println("부서번호>>");
		dep.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서이름>>");
		dep.setDepartmentName(sc.nextLine());
		return dep;
	}
	
	
	private int inputDepartmentId() {
		System.out.println("부서번호>>");
		return Integer.parseInt(sc.nextLine());
	}
	
	
	
	
}
