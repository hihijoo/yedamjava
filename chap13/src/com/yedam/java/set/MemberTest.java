package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class MemberTest {

	public static void main(String[] args) {
//중복 불가
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동",30));
		
		System.out.println("총 객체 수 " + set.size());
	}

}
