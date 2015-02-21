package com.slgerkamp.fpij.chapter01;

import java.util.List;

public class Cities {

	final List<String> cities;

	public Cities(List<String> cities) {
		this.cities = cities;
	}
	
	/**
	 * 命令型でパラメータの都市が存在するか判定する
	 * @param city
	 * @return
	 */
	public boolean containsByImperative(String city){
		
		boolean containsFlag = false;
		
		for(String s : cities){
			if(city.equals(s)){
				containsFlag = true;
				break;
			}
		}
		
		return containsFlag;
}

	/**
	 * 宣言型でパラメータの都市が存在するか判定する
	 * @param city
	 * @return
	 */
	public boolean containsByDeclarative(String city){
		
		return cities.contains(city);
		
	}

}
