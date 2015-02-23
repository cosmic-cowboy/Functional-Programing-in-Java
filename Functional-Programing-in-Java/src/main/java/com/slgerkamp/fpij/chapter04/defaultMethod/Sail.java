package com.slgerkamp.fpij.chapter04.defaultMethod;

/**
 * 4章 ラムダ式で設計する
 * 4.4 defaultメソッドを覗く
 */
public interface Sail {
	
	default public String turn()    {return "Sail::turn";}
	default public String cruise()  {return "Sail::cruise";}

}
