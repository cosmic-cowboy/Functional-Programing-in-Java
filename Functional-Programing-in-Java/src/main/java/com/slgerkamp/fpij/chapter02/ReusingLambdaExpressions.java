package com.slgerkamp.fpij.chapter02;

import java.util.List;
import java.util.function.Predicate;

public class ReusingLambdaExpressions {

	public static int countStartWithN(final List<String> friends, 
			final List<String> editors, final List<String> comrades){
		
		Long count = friends.stream()
					.filter(name -> name.startsWith("N"))
					.count();

		count += editors.stream()
				.filter(name -> name.startsWith("N"))
				.count();

		count += comrades.stream()
				.filter(name -> name.startsWith("N"))
				.count();

		return count.intValue();
	}

	public static int countStartWithN_Reuse(final List<String> friends, 
			final List<String> editors, final List<String> comrades){
		
		final Predicate<String> startWithN = name -> name.startsWith("N");
		
		Long count = friends.stream()
				.filter(startWithN)
				.count();

		count += editors.stream()
				.filter(startWithN)
				.count();

		count += comrades.stream()
				.filter(startWithN)
				.count();

		return count.intValue();
	}

}
