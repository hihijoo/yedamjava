package com.yedam.java.example2;

public class StudentRepo implements Access {
	
	//싱글톤 - 생성자는 무조건 프라이빗
	private static StudentRepo instance = new StudentRepo(); //내 안에서 인스턴스를 실행시키고 그거 변수고 가지고 있음
	
	private StudentRepo() { 
		init(); //필드를 하나 선언해야함 외부에서 뉴 연산자를 실행 할수 없어서 내부에서 뉴를 만들어서 접근 가능하도록 만든것(반드시 static으로 만들어야함)
	}
	
	//매소드로만 접근 할수 있게 만든것 반드시 클래스명으로만 접근 하는중
	public static StudentRepo getInstance() {
		return instance;
		}
	
	//실제 사용하는 메소드
	
	private Student[] dataList;
	private int listIndex;
	

	private void init() {
		dataList = new Student[100];
		listIndex = -1;
	}

	
	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;

	}
	
	//학생 정보 업데이트
	@Override
	public void update(Student student) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId() == student.getId()) {
				dataList[i] = student; //통채로 바꾸려고
			}
		}
	}
	
	//아이디 삭제
	@Override
	public void delete(int studentId) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				dataList[i] =null;
			}
		}
		
		cleanDataList(); //중간에 비어있는 공간을 압축 시키는것
	}
	
	private void cleanDataList() {
		//기존 데이터 -> 임시변수
		Student[] tempList = dataList;
		int tempIndex = listIndex;
		
		//기존 필드 초기화
		init();
		
		//임시변수에서 데이터만 기존 필드로 복사
		for(int i=0; i<=tempIndex; i++) {
			if(tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
		
	}

	
	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex+1]; 
		for(int i=0; i< list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	
	@Override
	public Student selectOne(int studentId) {
		Student selected = null; //변수선언
		for(int i=0; i<= listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				selected = dataList[i];
			
			}
		}
		return selected;
	}

}
