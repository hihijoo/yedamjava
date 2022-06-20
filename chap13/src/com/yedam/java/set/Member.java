package com.yedam.java.set;

public class Member {   ////약간 알겟음!!!!!!!!
	
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//주소
	@Override
	public int hashCode() {
		return name.hashCode() + age;
		
	}
	
	//내용
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return name.equals(m.name) && (age == m.age);
		}
	return false;
	}
}
