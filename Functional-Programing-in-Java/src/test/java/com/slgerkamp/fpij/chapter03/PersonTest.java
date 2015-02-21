package com.slgerkamp.fpij.chapter03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PersonTest {
	
	final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("Jane", 22),
				new Person("John", 20),
				new Person("Greg", 35)
			);
	
	@Test
	public void 年齢でソートする(){

		final List<Person> expected = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 22),
				new Person("Greg", 35)
			);
		
		List<Person> ageSortedList = people
			.stream()
			// ラムダ式
//			.sorted((person1, person2) -> person1.ageDifferent(person2))
			
			// メソッド参照に
			// この場合、
			// １つ目の引数がメソッド呼び出しのターゲット
			// ２つ目の引数が呼び出しの引数
			.sorted(Person::ageDifferent)
			.collect(Collectors.toList());
		
		// comparatorがないので比較ができない
		// かなり悲しいforループを使用
		// 名前は重複していない前提で名前での確認
		for(int i = 0; i < ageSortedList.size(); i++){
			String sortedItem = ageSortedList.get(i).name;
			String expectedItem = expected.get(i).name;
			assertThat(sortedItem, is(expectedItem));				
		}
		

	}
}
