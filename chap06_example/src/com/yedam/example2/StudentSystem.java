package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
	
		Student lee = new Student("이지원"); //값을 지정해준것
		System.out.println(Student.getSerialNum());
		System.out.println(lee.getName()+"의 학번 : " + lee.getStudentId());

		Student son = new Student("손수경");
		System.out.println(Student.getSerialNum());
		System.out.println(son.getName()+"의 학번 : " + son.getStudentId()); //+1씩 학번이 올라가는중
	
		System.out.println(lee.getName()+"의 학번 : " + lee.getStudentId()); //값은 변동되지 않음
	}

}
