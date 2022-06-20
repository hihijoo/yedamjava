package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamExample {

	public static void main(String[] args) throws Exception {
		
		//buffer 스트림이 없는 경우(어느 위치에 있던지 간에 알아서 끌어올 수 있음)
		// 물리적인 위치로 경로 지정하는 경우 파일위치 바뀌면 코드 어그러짐
	    // 이렇게 사용하면 위치 옮겨도 정보 따라온다.
	    // bufferstreamexample.class -> bufferstreamexample의 위치정보
	    // 내가 찾고자하는 파일정보 요구 get resource, 그 위치요구,실제 존재하는 위치 get path
		String originalFilePath1	
		= BufferStreamExample.class.getResource("originalFile1.jpg").getPath();
		
		String targetFilePath1 = "d:/dv/temp/targetFilePath1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		
		long nonBufferTime = copy(fis1,fos1); //현재 버퍼의 내용을 복사하여 넣음.
		
		System.out.println("버퍼를 사용하지 않았을 때 : " + nonBufferTime + "ns");
		
		fis1.close();
		fos1.close();
		
		
		//buffer 스트림이 있는 경우
		String originalFilePath2										
		= BufferStreamExample.class.getResource("originalFile1.jpg").getPath();
		
		String targetFilePath2 = "d:/dv/temp/targetFilePath2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(targetFilePath2);
		
		
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		//보조 스트림을 통해서 불러오겠다.
		long bufferTime = copy(bis,bos);
		System.out.println("버퍼를 사용했을 때 : " + bufferTime + "ns");
		
		fis2.close();
		fos2.close();
		
		
	}

	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		while (true) {
			data = is.read();
			if(data==-1) break;
			os.write(data);
	}
		long end = System.nanoTime();
		return (end-start);
	}
	
	
}

