package com.yedam.java.ch01;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("d:/dv/temp/test1.db");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		//write(int b)입력은 int타입이지만 출력은 끝 1byte를 출력함(총 4byte 입력 할 수 있음)
		os.write(a);
		os.write(b);
		os.write(c);
		
		//한번 밀어낸 다음에 클로즈해야함
		os.flush();
		os.close();
		
		
		//새로운것을 만듦
		os = new FileOutputStream("d:/dv/temp/test2.db");
		
		byte[] array1 = { 10,20,30 };
		
		os.write(array1);
		os.flush();
		os.close();
		
		
		os = new FileOutputStream("d:/dv/temp/test3.db");
		
		byte[] array2 = { 10,20,30,40,50 };
		
		//배열 3번째 부터 2개를 넘기겠당
		os.write(array2,3,2);
		os.flush();
		os.close();
		
		
	}

}
