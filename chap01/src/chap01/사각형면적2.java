package chap01;

import java.util.Scanner;

public class 사각형면적2 {

	public static void main(String[] args) {
		
		int w, h, area; //변수선언
		
		Scanner scan = new Scanner(System.in);
		System.out.print("가로입력:");
		w = Integer.parseInt(scan.nextLine());
		
		System.out.print("세로입력:");
		h = Integer.parseInt(scan.nextLine());
		
		area = w*h;
		System.out.println("면적:" + area);
		
		
	}

}
