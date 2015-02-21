package com.slgerkamp.fpij.chapter03;

public class Person {

	// 名前
	final String name;
	// 年齢
	final int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	};
	
	/**
	 * 年齢差
	 * @param other
	 * @return
	 */
	public int ageDifferent(final Person other){
		return age - other.age;
	}
	@Override
	public String toString() {
		return String.format("%s - %d", name, age);
	}
	
	
}
