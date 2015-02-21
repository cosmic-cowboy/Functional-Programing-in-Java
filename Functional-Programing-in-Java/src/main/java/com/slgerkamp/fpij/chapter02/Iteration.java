package com.slgerkamp.fpij.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {
	final List<String> iteration;

	public Iteration(List<String> iteration) {

		this.iteration = iteration;
	}

	/**
	 * forEach関数と匿名内部クラスを使ってListの詰め直し
	 * @return
	 */
	public List<String> addWithConsumerInstance(){
		
		final List<String> list = new ArrayList<>();
		iteration.forEach(new Consumer<String>() {

			@Override
			public void accept(String name) {
				list.add(name);
			}
			
		});
		
		return list;
	}

	/**
	 * forEach関数とラムダ式を使ってListの詰め直し
	 * @return
	 */
	public List<String> addWithLambda(){

		final List<String> list = new ArrayList<>();
		iteration.forEach(friend -> list.add(friend));
		iteration.forEach(list::add);
		return list;
	}

}
