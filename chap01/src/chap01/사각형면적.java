package chap01;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("가로입력:");
		int w = Integer.parseInt(scanner.nextLine() );	//가로값을 키보드로 입력받아서 w 변수에 저장
		
		System.out.print("세로입력:");
		int h = Integer.parseInt(scanner.nextLine() ); //세로입력
		
		int area = w*h; //면적계산
		System.out.println("면적=" + area); //면적출력
		
	}

}
