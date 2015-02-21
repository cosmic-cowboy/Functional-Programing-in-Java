package com.slgerkamp.fpij.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Transform {
	
	public final List<String> list;

	public Transform(List<String> list) {

		this.list = list;
		
	}
	/**
	 * ラムダ式を用いて、大文字に統一
	 * @return
	 */
	public List<String> upperWithForEach(){
		
		// 返却するためのリストを宣言する必要がある
		final List<String> uppercases = new ArrayList<>();
		
		list.forEach(name -> uppercases.add(name.toUpperCase()));
		
		return uppercases;
	}
	
	/**
	 * ラムダ式を用いて、大文字に統一
	 * @return
	 */
	public List<String> upperWithLambda(){
		
		return list
				.stream()
				.map(item -> item.toUpperCase())
				.collect(Collectors.toList());
	}
}
