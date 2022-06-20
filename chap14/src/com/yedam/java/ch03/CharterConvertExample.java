package com.yedam.java.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharterConvertExample {

	public static void main(String[] args) throws Exception {
		
		System.out.print("입력 문장>");
		String data = new Scanner(System.in).nextLine();
		write(data);
		read();
		

	}
	
	//출력스트림
	public static void write(String str) throws Exception {
		/*사용할 스트림(바이트 기반 스트림- 데이터 종류와 상관없이 읽어 들일 수 있음)
		 * 문자는 2byte를 읽어 들일 수 있음 그러다 보니 쪼개서 하나씩 읽어들이다 보니 처리 속도가 늦어짐
		 * 
		 */
		OutputStream os = new FileOutputStream("d:/dv/temp/text1.txt");
		
		//os.write(str); //스트링으로 바로 못넘김 output은 byte기반이기 때문에
		
		//연결된 보조 스트림(문자 기반 하위 스트림 outputStream이 Writer와 연결됨)
		Writer writer =  new OutputStreamWriter(os);
		
		writer.write(str);
		writer.flush();
		writer.close();
		
	}
	//입력스트림
	public static void read() throws Exception {
		InputStream is = new FileInputStream("d:/dv/temp/text1.txt");
	
		Reader reader = new InputStreamReader(is);
		
		char[] buffer = new char[100];
		int readCharNum = reader.read(buffer);
		
		reader.close();
		
		String data = new String(buffer,0,readCharNum);
		System.out.println(data);
	}
}
