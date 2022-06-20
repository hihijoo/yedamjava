package com.yedam.homework;

public class ProductSystem {

	private Product[] list; //product라는 배열을 쓰겠다. (이름이 list)
	private int index; //몇개의 수인지
	
	
	public ProductSystem() { //생성자 클래스와 이름이 같아야함
		index = -1;
	}
	//1. 상품 수 입력 
	public void setListSize(int size) { //몇칸 짜리인지 사이즈를 정해주는것
		list = new Product [size];
	}
	//2. 상품 및 가격 입력
	public void putProduct(String name,int price) {
		Product product = new Product(name, price);
		//Product product = new Product();  //생성자 public Product() {}로 했을때 
		//product.setName(name);
		//product.setPrice(price);
		
		list[++index] = product; //0을 맞추려고
		// list[++index] = new Product(name, price);
	}
	
	//3. 제품별 가격 출력
	public void printList() {
		for (int i=0; i<= index; i++) {
			//Product product = list[i];
			//System.out.println(product.getName() + " : " + product.getPrice());
		
			//3. 변수 선언 하지 않는 방법
			System.out.println(list[i].getName()+ " : " + list[i].getPrice());
		
			// 또다른 방법
			//list[i].showInfo();			
		}
	
	}
	
	//4. 분석 - 최고값을 가지는 제품의 가격   //제품명은 어떻게 나타내지..?
	public int getMaxProduct() {
		int max = list[0].getPrice();
		for (int i =0; i<=index; i++) {
			if (max < list[i].getPrice()) {
				max = list[i].getPrice();
			
			}
		}
		return max;
		
	}
	
	//4-1. 최고값을 가지는 제품의 명 - 도움을 받음
	public String getMaxName() {
		String maxPriceProduct = list[0].getName();
		int max = list[0].getPrice();
		for (int i =0; i<=index; i++) {
			if (max < list[i].getPrice()) {
				max = list[i].getPrice();
				maxPriceProduct = list[i].getName(); //최고가 가격이 있는 위치의 제품명
			}
		}
		return maxPriceProduct; 
	}
	
	
	//4-1 분석 - 최고값을 제외한 전체합
	public int getTotalPrice() {
		int sum =0;
		for (int i=0; i<=index; i++) {
			sum += list[i].getPrice();
		}
		int total = (sum - getMaxProduct());
		return total;
	}
	
	//4. 분석
	public void printTotal() {
		System.out.println("최고 가격제품은 "+getMaxName() + " : " + getMaxProduct() + "이고, "+getMaxName()+"의 값을 제외한 총합은 " +getTotalPrice()+"입니다.");
			
	}
	
	//5. 종료
	public void finish () {
		System.out.println("\n종료합니다.");
	}

}


