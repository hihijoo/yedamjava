package com.yedam.java.ch060501;

public class ObesityInfo extends StandardWeightInfo {

	ObesityInfo(String name, double height, double weight) {
		super(name, height, weight);

	}

	@Override
	public void getInformation() {
		System.out.printf("%s님의 신장 %.1f, 몸무게 %.1f, %s입니다.", name, height, height, BMI());
	}

	@Override
	public double getStandardWeight() {
		return super.getStandardWeight();
	}

	public double getObesity() {
		return (weight - super.getStandardWeight()) / super.getStandardWeight() * 100;
	}

	public String BMI() {

		double bmi = getObesity();
		String result;
		if (bmi <= 18.5) {
			result = "저체중";
		} else if (18.5 <= bmi && bmi < 23.0) {
			result = "정상";
		} else if (23.0 <= bmi && bmi < 25.0) {
			result = "과체중";
		} else if (25.0 <= bmi) {
			result = "비만";
		} else {
			result = "BMI 측정오류";
		}
		return result;
	}
}
