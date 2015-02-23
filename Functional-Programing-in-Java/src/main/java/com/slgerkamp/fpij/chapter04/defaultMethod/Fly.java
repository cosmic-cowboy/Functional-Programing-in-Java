package com.slgerkamp.fpij.chapter04.defaultMethod;

/**
 * 4章 ラムダ式で設計する
 * 4.4 defaultメソッドを覗く
 */
public interface Fly {
	
	default public String takeoff() {return "Fly::takeoff";}
	default public String land()    {return "Fly::land";}
	default public String turn()    {return "Fly::turn";}
	default public String cruise()  {return "Fly::cruise";}

}
