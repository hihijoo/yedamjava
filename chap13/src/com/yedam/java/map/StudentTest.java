package com.yedam.java.map;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {


	public static void main(String[] args) {
		
		/*hash map은 입력된 순서를 기억함 (현재 3개의 인스턴스가 생성된 new)
		 * Key에 대한 중복이 없으며 순서를 보장하지 않는다.
			Key와 Value 값으로 NULL을 허용한다.
		 */
		
		Map<Student, Integer> map = new HashMap<>();
		map.put(new Student(1 , "홍길동"),95);
		map.put(new Student(1 , "홍길동"),100);
		
		System.out.println("총 Entry 수 : "+ map.size());
		System.out.println("학번 : 1, 이름 : 홍길동, 성적 : "+ map.get(new Student(1,"홍길동")));
	
		/*
		Student s = new Student(1,"홍길동");
		map.put(s,95);
		map.put(s,100);
		
		System.out.println("총 Entry 수 : "+ map.size());
		System.out.println("학번 : 1, 이름 : 홍길동, 성적 : "+ map.get(s));
		*/
		
	}

}
