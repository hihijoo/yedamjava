
package com.yedam.homework;

public class ProductSystem2 { //쌤이랑 하는거라서 오류가 있을 수있음

	private Product[] list; //product라는 배열을 쓰겠다. 이름은 list이다
	private int index; //몇개의 수인지
	
	
	public ProductSystem2() { //생성자 클래스와 이름이 같아야함
		index = -1;
	}
	//1. 상품 수 입력 
	public void setListSize(int size) {
		list = new Product [size];
	}
	//2. 상품 및 가격 입력
	public void putProduct(String name,int price) {
		Product product = new Product(name,price);
		product.setName(name);
		product.setPrice(price);
		
		list[++index] = product; //-1이라서 ++해줘야지 0이 됨
	}
	//3. 제품별 가격 출력
	public void printList() {
		for (int i=0; i<= index; i++) {
			Product product = list[i];
			//System.out.println(product.getName() + " : " + product.getPrice());
		
			//3. 변수 선언 하지 않는 방법
			System.out.println(list[i].getName()+ " : " + list[i].getPrice());
		
			// 또다른 방법
			//list[i].showInfo();			
		}
	
	}
	
	//4. 분석 - 최고값을 가지는 제품   //제품명은 어떻게 나타내지..?
	
	public Product getMaxPriceInfo() { //제품명이랑 가격이랑 같이 가져올라고
		Product maxInfo = list[0]; //maxinfo라는 변슈를 지정함 
		for(int i=1; i<=index; i++) {//0번째값을 넣으면 두번 계산이 됨 , 0은 넣었으니까 1부터
			if(maxInfo.getPrice() < list[i].getPrice()) {
				maxInfo = list[i];
			}
		}
		return maxInfo;
	}
	
	
	//4-1 분석 - 최고값을 제외한 전체합
	public int getTotalPrice() {
		int sum = 0;
		for (Product temp : list) {
			sum += temp.getPrice();
		}
		Product maxInfo = getMaxPriceInfo();
		int result = sum - maxInfo.getPrice();
		// 위에와 같은것 int result = sum - getMaxProductInfot().getPrice();
		
		result = 0; //초기화를 시켜야함
		for(Product temp : list) {
			if(temp.getPrice() == maxInfo.getPrice())
				continue; //반복문에서 만나면 밑으로 가는게 아니라 다시 올라가는것
			result += temp.getPrice();
			
			// if(temp.getPrice() < maxInfo.getPrice()) {
			// result += temp.getPrice();
		}
		
		return result;
	}
	
	
	//5. 종료
	public void finish () {
		System.out.println("\n종료합니다.");
	}

}


