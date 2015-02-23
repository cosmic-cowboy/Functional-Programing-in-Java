package com.slgerkamp.fpij.chapter04.defaultMethod;

/**
 * 4章 ラムダ式で設計する
 * 4.4 defaultメソッドを覗く
 */
public class SeaPlane extends Vehicle implements FastFly, Sail{

	private int altitude;
	
	public String cruise(){
		if(altitude > 0){
			return FastFly.super.cruise();
		} else {
			return Sail.super.cruise();
		}
	}
	
}
