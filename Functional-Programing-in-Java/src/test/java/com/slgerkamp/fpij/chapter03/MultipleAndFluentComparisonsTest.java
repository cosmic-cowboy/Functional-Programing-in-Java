package com.slgerkamp.fpij.chapter03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import org.junit.Test;

import com.slgerkamp.fpij.chapter03.helper.PersonComparedHelper;

/**
 * 3.3 複数のプロパティによる流暢な比較
 *
 */
public class MultipleAndFluentComparisonsTest {
	
	// テスト対象リスト
	final List<Person> people = Arrays.asList(
			new Person("Sara", 21),
			new Person("Jane", 21),
			new Person("John", 20),
			new Person("Greg", 35)
		);
	
	// 名前でソートした期待リスト
	final List<Person> nameSortedexpected = Arrays.asList(
			new Person("Greg", 35),
			new Person("Jane", 21),
			new Person("John", 20),
			new Person("Sara", 21)
		);

	// 名前と年齢でソートした期待リスト
	final List<Person> ageAndNameSortedexpected = Arrays.asList(
			new Person("John", 20),
			new Person("Jane", 21),
			new Person("Sara", 21),
			new Person("Greg", 35)
		);

	
	@Test
	public void 名前でソートする_内部クラス構文(){

		List<Person> nameSortedList = people
			.stream()
			.sorted((person1, person2) -> person1.name.compareTo(person2.name))
			.collect(toList());
		
		PersonComparedHelper.assertHelper(nameSortedList, nameSortedexpected);
		
	}
	
	@Test
	public void 名前でソートする_コンビニエンス関数(){

		final Function<Person, String> byName = person -> person.name;
		
		// Comparatorのコンビニエンス関数
		// comparingは与えられたラムダ式からComparatorインタフェースを作成
		List<Person> nameSortedList = people
			.stream()
			.sorted(comparing(byName))
			.collect(toList());
		
		PersonComparedHelper.assertHelper(nameSortedList, nameSortedexpected);
	}
	
	@Test
	public void 年齢と名前でソートする_コンビニエンス関数(){

		final Function<Person, Integer> byAge  = person -> person.age;
		final Function<Person, String> byName = person -> person.name;
		
		List<Person> ageAndNameSortedList = people
			.stream()
			.sorted(comparing(byAge).thenComparing(byName))
			.collect(toList());
		
		PersonComparedHelper.assertHelper(ageAndNameSortedList, ageAndNameSortedexpected);
	}

}
