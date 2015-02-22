package com.slgerkamp.fpij.chapter03.helper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.slgerkamp.fpij.chapter03.Person;

public class PersonComparedHelper {
	
	/**
	 * comparatorがないので比較ができない
	 * かなり悲しいforループを使用
	 * 名前は重複していない前提で名前での確認
	 * @param actual
	 * @param expected
	 */
	public static void assertHelper(final List<Person> actual, final List<Person> expected){
		for(int i = 0; i < actual.size(); i++){
			String sortedItem = actual.get(i).name;
			String expectedItem = expected.get(i).name;
			assertThat(sortedItem, is(expectedItem));				
		}
		
	}
}