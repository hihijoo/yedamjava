package com.yedam.java.ch0604_01;

public class Calculator {

	// 1. 개수 입력
	int[] numList; // 입력받을 숫자를 선언
	int index;
	int di;

	Calculator() {
		index = -1;
	}

	void setArraySize(int size) {
		numList = new int[size];
	}

	// 2. 숫자 입력
	void setNum(int num) {
		if (index < numList.length - 1) { // 길이는 0부터 인덱스는 1부터
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더이상 입력할 수 없습니다.");
		}
	}

	// 3. 더하기
	void plus() {
		if (isExecuted()) {
			int sum = 0;
			for (int i = 0; i <= index; i++) { // length는 = 쓰면 안됨
				sum += numList[i];
			}
			System.out.println("모두 더한 결과 : " + sum);
		}

	}

	// 4. 빼기
	void sub() {
		if (isExecuted()) {
			int sub = numList[0]; // 배열에서 처번째 값을 가짐
			for (int i = 1; i <= index; i++) { // 그다음 두번째 값부터 가져가야하니까 1부터
				sub -= numList[i];
			}
			System.out.println("모두 뺀 결과 : " + sub);
		}
	}

	// 5. 곱하기
	void mu() {
		if (isExecuted()) {
			int mu = numList[0];
			for (int i = 1; i <= index; i++) {
				mu *= numList[i];
			}
			System.out.println("모두 곱한 결과 : " + mu);
		}
	}

	// 6.나누기
	void di() {
		if (isExecuted()) {
			for (int i = 1; i <= index; i++) {
				if (numList[i] == 0) {
					System.out.println("0이외의 다른 숫자를 입력하세요.");
					return;
				}

				di /= numList[i];
			}
			System.out.println("모두 나눈 결과 : " + di);
		}
	}

	// 0. 조건 체크
	boolean isExecuted() { // 실행 할 수 있냐?
		if ((index + 1) >= 2) {
			return true;
		} else {
			System.out.println("숫자를 더 입력해주세요.");
			return false;
		}
	}
}
