package com.yedam.example2;

public class Student {

	//필드
	private static int serialNum = 1000; //정적필드, 공유되는 값//고정되어 있음
	
	private int studentId; //학번
	private String name; //
	
	//생성자
	public Student(String name) {
		serialNum++;
		this.studentId = serialNum; //학번을 시리얼 넘버로 복사할거임
		this.name = name;
	}
	
	//매소드
	public static int getSerialNum() {//시리얼 넘버는 static임, 그래서 메소드도 static
		return serialNum;
	}

	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
}

