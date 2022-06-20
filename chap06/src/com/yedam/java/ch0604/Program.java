package com.yedam.java.ch0604;

	//1. 학생수 입력
	//2. 점수 입력
	//3. 점수 리스트 출력
	//4. 분석 - 최고점수, 평균 점수
	
public class Program {
	//필드
	int[] scores; // scores라는 배열을 지정,선언
	int index; //0부터 시작해도 됨

	//생성자 -class이름이랑 같아야함
	Program() {
		index = -1; //현재값이 있는 위치를 가르키는것 배열의 인덱스는 0부터 시작하지만 인덱스로의 역할을 못하니까(존재하지 않으니까) -1로
	}
	//생성자
	
	//메소드

	//1. 학생 수 입력 - 배열을 초기화해야하기 때문에
	void setStudentsNum(int student) { //배열수를 학생수만큼 정해 놓은것
		scores= new int[student];
	}
	
	//2.
	void setStudentScore(int score) {
		scores[++index] = score; //-1에서 +1한 0이 스코어에 들어감
		
	}
	
	
	//3. 점수 리스트 출력 -값을 반환할 필요는 없음
	void printScores() { //점수를 출력함
		for(int i=0; i<scores.length; i++) {
			System.out.println("scores["+i+"]>"+scores[i]);
		}
	}
		
	//4-1. 최고점수
		int getMaxScore( ) {	
			int max = scores[0]; //최고점수
			for(int i=0; i<scores.length; i++) { //어느게 큰지 모르니까 모두 비교해야함	
				int temp = scores[i];
				if (max < temp) {
				max=temp;
				}
			}
			return max; 
		}
	//4-2. 평균점수
		double getAvgScore() {
			int sum = 0;
			for(int i=0; i<scores.length; i++) {
				sum += scores[i]; //i번째까지 누적시키는것 sum=sum+scores[i];
				}
			return (double)sum / scores.length; //연산식도 리턴 가능 - 강제로 더블로 만들어줘야함 원래는 int값이니까
			}
	//4. 분석
	void printResult() {
		System.out.println("최고점수 : "+getMaxScore());
		System.out.println("평균점수 : "+getAvgScore());
	}
			
		}

