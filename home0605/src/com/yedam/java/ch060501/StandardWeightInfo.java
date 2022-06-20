package com.yedam.java.ch060501;

public class StandardWeightInfo extends Human {

	StandardWeightInfo(String name, double height, double weight) {
		super(name, height, weight);
	
	}

	@Override
	public void getInformation() {
		
		System.out.println(name + "님의 신장 "+height +", 몸무게 "+weight +", 표준체중 " + getStandardWeight() + "입니다.");
		
	}
	
	public double getStandardWeight() {
		double stWeight = 0;
		stWeight = (this.height - 100) * 0.9;
		
		return stWeight;
	} 
	

}
