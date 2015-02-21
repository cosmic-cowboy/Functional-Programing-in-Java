package com.slgerkamp.fpij.chapter02;

import java.util.List;
import java.util.Optional;

public class PickingAnElement {

	public final List<String> list;

	public PickingAnElement(List<String> list) {

		this.list = list;

	}
	
	/**
	 * 指定された値を抽出する
	 * Java8 以前の場合
	 * @param startingLetter
	 * @return
	 */
	public String pickName_BeforeJava8(final String startingLetter){
		String foundName = null;
		for(String name : list){
			if(name.startsWith(startingLetter)){
				foundName = name;
				break;
			}
		}
		if(foundName == null){
			foundName = "";
		}
		return foundName;
	}
	/**
	 * 指定された値を抽出する
	 * Java8 以前の場合
	 * @param startingLetter
	 * @return
	 */
	public String pickName(final String startingLetter){
			
		Optional<String> op_name = list.stream()
						.filter(name -> name.startsWith(startingLetter))
						.findFirst();
		return op_name.orElse("");

	}

}
