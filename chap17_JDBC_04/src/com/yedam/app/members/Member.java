package com.yedam.app.members;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Member {

	private String memberId;
	private String memberPassword;
	
	// memberRole0 : 관리자, 1- 일반
	private int memberRole;
	
	private String memberName;

	
	@Override
	public String toString() {
		String info = "";
		if(memberRole == 0) {
			info = "관리자 계정 : " + memberId;
		}else  {
			info = "일반 계정 : " + memberId;
			
		}
		return info;
	}
	
	
}
