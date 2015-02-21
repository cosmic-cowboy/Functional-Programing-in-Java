package com.slgerkamp.fpij.chapter03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/**
 * 3.1 文字列のイテレーション
 *
 */
public class IterateStringTest {

	final String str = "w00t";
	
	@Test
	public void 文字列からIntegerストリームを抽出する(){

		Integer [] confirmArray = {119, 48, 48, 116};
		List<Integer> expected = Arrays.asList(confirmArray);
		List<Integer> list = new ArrayList<>();
		
		str.chars().forEach(list::add);
		assertThat(list, is(expected));	

	}

	@Test
	public void 文字列から文字を抽出する(){

		Character [] confirmChar = {'w','0','0','t'};
		List<Character> extractList = new ArrayList<>();
		// 自作メソッドでもメソッド参照は可能
		// str.chars().forEach(IterateSring::printChar);
		str.chars().forEach(character -> extractList.add(Character.valueOf((char)character)));
		assertThat(extractList, is(Arrays.asList(confirmChar)));	

	}

	@Test
	public void 文字列から数字を抽出する(){

		Integer [] confirmChar = {0,0};
		List<Integer> extractList = new ArrayList<>();

		// 自作メソッドでもメソッド参照は可能
		// str.chars().filter(Character::isDigit).forEach(IterateSring::printChar);
		str.chars()
			.filter(Character::isDigit)
			.forEach(character -> extractList.add(Integer.parseInt(String.valueOf((char)character))));
		
		assertThat(extractList, is(Arrays.asList(confirmChar)));	
		

	}


}
