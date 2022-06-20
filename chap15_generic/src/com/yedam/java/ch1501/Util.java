package com.yedam.java.ch1501;

public class Util {

	//메소드가 제네릭 타입
	public static <T> BoxA <T> boxing (T t) {
		//
		BoxA<T> box = new BoxA<>();
		box.set(t);
		return box;
	}
	
	//메소드가 제네릭 타입
	public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
		//제네릭으로 하면 어떤 타입일 지 알 수 없음. 그래서 equals를 이용해서 비교해야함
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	//내부에서만 사용하는 제네릭
	public static <K, V> V printInfo(K key) {
		V v = null;
		return v;
	}

}
