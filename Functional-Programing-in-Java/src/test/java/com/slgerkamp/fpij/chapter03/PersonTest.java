package com.slgerkamp.fpij.chapter03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.slgerkamp.fpij.chapter03.helper.PersonComparedHelper;

/**
 * 3.2 Comparatorインタフェースを実装
 *
 */
public class PersonTest {
	
	final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("Jane", 22),
				new Person("John", 20),
				new Person("Greg", 35)
			);

	// 昇順ソートの期待値
	final List<Person> ascendingByAgeExpected = Arrays.asList(
			new Person("John", 20),
			new Person("Sara", 21),
			new Person("Jane", 22),
			new Person("Greg", 35)
		);

	// 降順ソートの期待値
	final List<Person> descendingByAgeExpected = Arrays.asList(
			new Person("Greg", 35),
			new Person("Jane", 22),
			new Person("Sara", 21),
			new Person("John", 20)
		);
	
	@Test
	public void 年齢でソートする(){
		
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
		
		// 昇順ソートの確認
		PersonComparedHelper.assertHelper(ageSortedList, ascendingByAgeExpected);
	}

	@Test
	public void 年齢で昇順と降順にソートする(){

		// 昇順ソート
		Comparator<Person> compareAscending = 
				(person1, person2) -> person1.ageDifferent(person2);
		
		List<Person> ascendingSortedList = people
			.stream()
			.sorted(compareAscending)
			.collect(Collectors.toList());

		// 降順ソート
		Comparator<Person> compareDescending = compareAscending.reversed();
		List<Person> descendingSortedList = people
				.stream()
				.sorted(compareDescending)
				.collect(Collectors.toList());

		// 昇順ソートの確認
		PersonComparedHelper.assertHelper(ascendingSortedList, ascendingByAgeExpected);
		// 降順ソートの確認
		PersonComparedHelper.assertHelper(descendingSortedList, descendingByAgeExpected);
	}

	@Test
	public void 最年少(){

		final Person youngest = new Person("John", 20);

		Optional<Person> person = people
			.stream()
			.min(Person::ageDifferent);
		
		// comparatorがないので比較ができない
		// 名前は重複していない前提で名前での確認
		assertThat(person.get().name, is(youngest.name));				
	}
	
	@Test
	public void 最年長(){

		final Person eldest = new Person("Greg", 35);

		Optional<Person> person = people
			.stream()
			.max(Person::ageDifferent);
		
		// comparatorがないので比較ができない
		// 名前は重複していない前提で名前での確認
		assertThat(person.get().name, is(eldest.name));				
	}


}
