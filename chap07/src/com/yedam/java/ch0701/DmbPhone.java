package com.yedam.java.ch0701;

			   //자식   상속   부모
public class DmbPhone extends Phone { //phone은 디폴트인 object(아무것도 지정안했을때 있는거)를 상속함
	
	int ch;
	
	public DmbPhone(String model, String color) { //phone에 생성자를 형성 했으면 오류가 남
		//super(); //생성자를 선언하지 않으면 컴파일러가 알아서 호출함 new라는걸 굳이 쓸 필요 없음(내부니까)
				//부모를 호출하고 싶으면 super를 써라
		super(model,color);
			//아래 두줄과 위에 super이 같은것
		//this.model = model; //this는 인스턴스에 대해서만 접근 가능함(원칙) 내껀지 부모껀지 구분이 안됨
		//super.color = color; // super을 써도 됨
		this.ch = 10; // super로 접근이 안됨 본인꺼니까 10번을 지정한것
	
	}
	
	void turnOnDmb() {
		System.out.println("채널 " + ch+"번 방송 수신을 시작합니다.");
	}

	@Override
	protected void bell() {
		// TODO Auto-generated method stub
		super.bell();
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		super.call();
	}

	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}
	
	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널" + ch + "번으로 바꿉니다.");
	}
}
