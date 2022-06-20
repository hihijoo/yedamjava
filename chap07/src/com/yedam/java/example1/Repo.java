package com.yedam.java.example1;

//고객정보를 저장하는 저장소

public class Repo {
	//필드
	private Customer[] dataList;
	private int listIndex;
	
	//생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;	
	}
	
	//메소드
	//등록
	public void insert(Customer customer) { //회원 저장 정보
		dataList[++listIndex] = customer;
	}
	
	
	//수정
	public void update(Customer customer) {
		for (int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerId() == customer.getCustomerId()) { //내주소를 찾는것
				dataList[i] = customer; // 같으면 그 정보를 다 가져옴
				}
		}
	}
	
	//삭제
	public void delete(int customerId) {
		//데이터 삭제
		for (int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerId() == customerId) { //아이디만 찾는것
				dataList[i] = null; //정보를 끊는다. 삭제한다기 보다는
		}
	}
		//데이터 정리
		cleanDataList();
		
	}

	private void cleanDataList() {
		//기존 데이터, 임시 변수에 복사
		Customer[] temp = dataList; //통째로 복사한거
		int tempIndex = listIndex;
		
		//기존 데이터를 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;
		
		for(int i=0; i<=tempIndex; i++) {
			if(temp[i] == null) {
				continue; //null 이면 건너
			}			
			dataList[++listIndex] = temp[i];
		}
	}
	
	//조회
	public Customer[] selectALL () {
		return dataList;
	}
	
	public Customer selectOne(int customerId) {
		Customer selected = null;
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	
		
	}
	
	
}
