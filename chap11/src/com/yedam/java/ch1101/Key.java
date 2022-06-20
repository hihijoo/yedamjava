package com.yedam.java.ch1101;

public class Key {

	public int number;
	
	public Key(int number) {
		this.number = number;
		
	}
	

	@Override
	public boolean equals(Object obj) { //논리적으로 동등한지
		if(obj instanceof Key) {
			Key key = (Key)obj;
			if(number == key.number) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() { //물리적으로 동등한지
		return number;
	}
	

	@Override
	public String toString() {
		return "Key [number=" + number + "]";
	}
	
}
