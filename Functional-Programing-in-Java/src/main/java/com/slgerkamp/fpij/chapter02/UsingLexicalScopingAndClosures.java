package com.slgerkamp.fpij.chapter02;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsingLexicalScopingAndClosures {

	public final List<String> list;

	public UsingLexicalScopingAndClosures(List<String> list) {
		this.list = list;
	}
	
	public long countStartWithLetter_CreatePredicate(){
		return list
				.stream()
				.filter(startWithLetterPredicate("N"))
				.count();
	}
	
	/**
	 * 静的スコープ・クロージャを利用して、DRYを実現する
	 * @param letter
	 * @return
	 */
	public Predicate<String> startWithLetterPredicate(String letter){
		return name -> name.startsWith(letter);
	}

	/**
	 * 
	 * @return
	 */
	public long countStartWithLetter_CreateFunction(){
		return list
				.stream()
				.filter(startWithLetterFunction.apply("N"))
				.count();
	}
	
	
	/**
	 * 関数を用いてより安全に、DRYを実現する
	 */
	public Function<String, Predicate<String>> startWithLetterFunction = 
			letter -> name  -> name.startsWith(letter);

}
