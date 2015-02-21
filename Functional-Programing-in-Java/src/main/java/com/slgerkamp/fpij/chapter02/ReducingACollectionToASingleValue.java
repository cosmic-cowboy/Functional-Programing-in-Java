package com.slgerkamp.fpij.chapter02;

import java.util.List;
import java.util.Optional;

public class ReducingACollectionToASingleValue {

	public final List<String> list;

	public ReducingACollectionToASingleValue(List<String> list) {
		this.list = list;
	}
	
	/**
	 * コレクションの要素の長さの合計を集計する
	 * @return
	 */
	public int nameLength(){
		return list.stream()
				.mapToInt(name -> name.length())
				.sum();
	}
	
	/**
	 * コレクションの中でもっとも長い要素を抽出する
	 * @return
	 */
	public Optional<String> longestElement(){
		return list.stream()
				.reduce((name1, name2) ->
				name1.length() >= name2.length() ? name1 : name2);
	}

	/**
	 * コレクションの中でもっとも長い要素を抽出する
	 * @return
	 */
	public String longestElementWithDefault(){
		return list.stream()
				.reduce("Defalut", (name1, name2) ->
				name1.length() >= name2.length() ? name1 : name2);
	}

}
