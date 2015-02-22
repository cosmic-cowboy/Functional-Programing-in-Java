package com.slgerkamp.fpij.chapter03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;

import org.junit.Test;

import com.slgerkamp.fpij.chapter03.helper.PersonComparedHelper;

/**
 * 3-4 collectメソッドとCollectorsクラスの使用
 *
 */
public class UsingCollectionsTest {
	
	final List<Person> people = Arrays.asList(
			new Person("Sara", 21),
			new Person("Jane", 21),
			new Person("John", 20),
			new Person("Greg", 35)
		);

	final List<Person> expectedOlderThan20List = Arrays.asList(
			new Person("Sara", 21),
			new Person("Jane", 21),
			new Person("Greg", 35)
		);
	
	@Test
	public void 年齢が21歳以上の人を抽出する_forEachを用いて(){
		
		List<Person> selectOlderThan20List = new ArrayList<>();
		people
			.stream()
			.filter(person -> person.age > 20)
			.forEach(person -> selectOlderThan20List.add(person));
		
		// 昇順ソートの確認
		PersonComparedHelper.assertHelper(selectOlderThan20List, expectedOlderThan20List);
	}

	
	@Test
	public void 年齢が21歳以上の人を抽出する_collectとメソッド参照を用いて(){
		
		List<Person> selectOlderThan20List = people
			.stream()
			.filter(person -> person.age > 20)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		// 昇順ソートの確認
		PersonComparedHelper.assertHelper(selectOlderThan20List, expectedOlderThan20List);
	}
	
	@Test
	public void 年齢が21歳以上の人を抽出する_collectとコンビニエンスメソッドを用いて(){
		
		List<Person> selectOlderThan20List = people
			.stream()
			.filter(person -> person.age > 20)
			.collect(toList());
		
		// 昇順ソートの確認
		PersonComparedHelper.assertHelper(selectOlderThan20List, expectedOlderThan20List);
	}
	
	@Test
	public void 年齢別にグループ化(){
		
		Map<Integer, List<Person>> groupList = 
				people
				.stream()
				.collect(groupingBy(person -> person.age));

		assertThat(groupList.get(20).size(), is(1));
		assertThat(groupList.get(21).size(), is(2));
		assertThat(groupList.get(35).size(), is(1));


	}
	
	@Test
	public void 年齢別に名前を抽出(){
		
		Map<Integer, List<String>> groupList = 
				people
				.stream()
				.collect(groupingBy(person -> person.age, mapping(person -> person.name, toList())));

		List<String> list20years = groupList.get(20);
		List<String> list21years = groupList.get(21);
		List<String> list35years = groupList.get(35);
		
		assertThat(list20years.size(), is(1));
		assertThat(list21years.size(), is(2));
		assertThat(list35years.size(), is(1));

		assertThat(list20years.contains("John"), is(true));
		assertThat(list21years.contains("Jane"), is(true));
		assertThat(list21years.contains("Sara"), is(true));
		assertThat(list35years.contains("Greg"), is(true));		

	}

	
	@Test
	public void 名前の頭文字でグループ化し_グループごとの最年長を抽出(){
		
		Comparator<Person> byAge = Comparator.comparing(person -> person.age);
		Map<Character, Optional<Person>> oldestPersonOfEachLetter = 
				people
				.stream()
				.collect(
						groupingBy(
								person -> person.name.charAt(0), reducing(BinaryOperator.maxBy(byAge))
						)
				);
		
		assertThat(oldestPersonOfEachLetter.get('S').get().name, is("Sara"));		
		assertThat(oldestPersonOfEachLetter.get('G').get().name, is("Greg"));		
		assertThat(oldestPersonOfEachLetter.get('J').get().name, is("Jane"));		
		
	}
}
