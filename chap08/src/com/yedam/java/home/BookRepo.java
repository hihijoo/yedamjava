package com.yedam.java.home;

public class BookRepo implements BookAccess {

	
	//dao는 주로 싱글톤 - 생성자는 무조건 프라이빗으로
	private static BookRepo instance = new BookRepo();

	private BookRepo(){
		init();
	}
	
	public static BookRepo getInstace() {
		return instance;
	}

	//실제 사용하는 필드 및 메소드
	private Book[] dataList;
	private int listIndex;
	
	private void init( ) { //초기화
		dataList = new Book[100];
		listIndex = -1; //배열은 0부터 시작해야하니까 -1로 지정했으면
	}
	
	@Override
	//등록
	public void insert(Book book) {
		dataList[++listIndex] = book; //여기서 ++해서 0으로 만들어줘야함
	}

	@Override
	//갱신
	public void update(Book book) {
		for (int i=0; i<listIndex; i++) {
			if(dataList[i].getIsbn() ==  book.getIsbn()) {
				dataList[i] = book; 
			}
		}
	}
 
	@Override
	// 삭제
	public void delete(int isbn) {
		for( int i=0; i<=listIndex; i++) {
			if(dataList[i].getIsbn() == isbn) {
				dataList[i] = null;
			}
		}
		cleanDataList(); //중간에 null인 공간을 압축 시킬 필요가 있음
	}

	private void cleanDataList() {
		//기존 데이터를 임시 변수에 넣는다.
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		
		// 기존 필드를 초기화
		init();
		
		//임시 변수에 데이터만 기존 필드로 복사함
		for(int i=0; i<= tempIndex; i++) { //0부터니까 =을 넣어줘야함
			if(tempList[i] != null) {
				dataList[++listIndex] = tempList[i]; //null이 아닌 경우 새로운 인덱스 번호를 넣어줌
			}
		}
	}
	
	@Override
	//전체조회
	public Book[] selectAll() {
		Book[] list = new Book[listIndex+1];
		for(int i=0; i<=listIndex; i++) { //배열의 방 개수니까 =이 필요 없음
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	//선택조회
	public Book selectOne(int isbn) {
		Book selected = null; //변수 선언
		for (int i=0; i<= listIndex; i++) {
			if (dataList[i].getIsbn() == isbn) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}
	
}