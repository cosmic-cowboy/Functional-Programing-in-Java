package com.slgerkamp.fpij.chapter02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReusingLambdaExpressionsTest {

	public static final List<String> friends = 
	    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	public static final List<String> editors = 
	    Arrays.asList("Brian", "Jackie", "John", "Mike");
	public static final List<String> comrades =                      
	    Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	
	@Test
	public void Nで始まる名前の数を抽出_ラムダ式の重複あり(){
		
		assertThat(ReusingLambdaExpressions.countStartWithN(friends, editors, comrades), is(3));	
	}

	@Test
	public void Nで始まる名前の数を抽出_ラムダ式の重複なし(){
		
		assertThat(ReusingLambdaExpressions.countStartWithN_Reuse(friends, editors, comrades), is(3));	
	}


}
