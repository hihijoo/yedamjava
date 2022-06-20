package homework;

public class CalculatorHome {
	// 1. 개수입력
	int[] scoreList;
	int[] scores;
	int index;
	double all =0; //평균
	double avg = 0;
	
	

	// 생성자 클래스와 이름이 같아야함
	CalculatorHome() {
		index = -1;
	}//현재 내가 몇개를 입력했는지 알기 위해서

	// 1.학생 수 입력
	void setStudentNum(int student) {
		scores = new int[student];
	}

	// 2. 점수 입력
	// 1) 점수 : 100점
	// 2) 점수 : 73점
	// 3) 점수 : 92점
	// 4) 점수 : 65점
	// 5) 점수 : 86점
	void setStudentScore(int score) {
		scores[++index] = score; // -1에서 +1한 0이 스코어에 들어감
	}

	// 3. 전체조회 구현
	void printScores() {
		for (int i = 0; i <= index; i++) {
			System.out.println("scores[" + i + "]>" + scores[i]);
		}
	}

	// 4-1. 최고점수
	int getMaxScore() {
		int max = scores[0];
		for (int i = 0; i <= index; i++) {
			int temp = scores[i];
			if (max < temp) {
				max = temp;
			}
		}
		return max;
	}

	// 4-2. 최저 점수
	int getMinScore() {
		int min = scores[0];
		for (int i = 0; i <= index; i++) {
			int temp2 = scores[i];
			if (min > temp2) {
				min = temp2;
			}
		}
		return min;
	}

	// 4-3. 평균점수(최고점과 최저점을 제외)-소수점 두자리
		double getAvgScore() {
			int sum = 0;
			for (int i = 0; i <= index; i++) {
				sum += scores[i];
			}
			all = sum - (getMaxScore() + getMinScore());
			return all/(index -1) ; //
	}
	//4 학생정보 분석

	void printResult() {
		System.out.println("최고점수는 " + getMaxScore() + "입니다.");
		System.out.println("최저점수는 " + getMinScore() + "입니다.");
		System.out.printf("평균은 %.2f 입니다.\n", getAvgScore());

	}
}