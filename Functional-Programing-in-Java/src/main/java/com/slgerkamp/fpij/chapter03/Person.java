package com.slgerkamp.fpij.chapter03;

/**
 * 3.2 Comparatorインタフェースを実装
 * 
 *
 */
public class Person {

	// 名前
	final public String name;
	// 年齢
	final public int age;
	
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
