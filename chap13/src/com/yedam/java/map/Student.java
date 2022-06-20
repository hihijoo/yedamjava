package com.yedam.java.map;

public class Student {
	
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	/*물리적으로 존재하는 위치가 같은지 비교하는 것
	string 내부 값이 같으면 동일 한 값을 가져오게 함
	*/
	@Override
	public int hashCode() {
		return name.hashCode() + sno;
		
	}

	/*내부에 필드에 존재하는 값이 같은지 비교하는 것
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) { //동일한 student 타입인지 확인해야함
			Student s =(Student)obj; //강제 타입 변환
			return name.equals(s.name) && (sno == s.sno);
		}
		
		return false;
		
	}
	
	
}
