package com.slgerkamp.fpij.chapter02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class ReducingACollectionToASingleValueTest {

	public static final List<String> friends = 
	    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	public static final List<String> editors = 
	    Arrays.asList("Brian", "Jackie", "John", "Mike");
	public static final List<String> comrades =                      
	    Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	
	@Test
	public void コレクション内の文字列の長さを合計する(){
		assertThat(new ReducingACollectionToASingleValue(friends).nameLength(), is(26));	
	}

	@Test
	public void コレクション内でもっとも長い要素を抽出(){
		assertThat(new ReducingACollectionToASingleValue(friends).longestElement(), is(Optional.of("Brian")));	
	}

	@Test
	public void  コレクション内でもっとも長い要素を抽出_デフォルト値を持つ(){
		assertThat(new ReducingACollectionToASingleValue(new ArrayList<String>()).longestElementWithDefault(), is("Defalut"));	
	}


}
