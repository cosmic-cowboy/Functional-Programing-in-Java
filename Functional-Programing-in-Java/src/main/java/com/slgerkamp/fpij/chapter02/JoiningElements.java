package com.slgerkamp.fpij.chapter02;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningElements {

	public final List<String> list;

	public JoiningElements(List<String> list) {

		this.list = list;

	}
	
	/**
	 * 文字列連結
	 * @return
	 */
	public String join(){
		return list.stream().collect(Collectors.joining(", "));
	}

}
