package com.slgerkamp.fpij.chapter04.defaultMethod;

/**
 * 4章 ラムダ式で設計する
 * 4.4 defaultメソッドを覗く
 */
public interface FastFly extends Fly {
	
	default public String takeoff() {return "FastFly::takeoff";}

}
