package com.slgerkamp.fpij.chapter02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PickingAnElementTest {

	public static final List<String> friends = 
	    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	public static final List<String> editors = 
	    Arrays.asList("Brian", "Jackie", "John", "Mike");
	public static final List<String> comrades =                      
	    Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	
	@Test
	public void Nで始まる名前を抽出_BeforeJava8(){
		
		assertThat(new PickingAnElement(friends).pickName_BeforeJava8("N"), is("Nate"));	
		assertThat(new PickingAnElement(friends).pickName_BeforeJava8("0"), is(""));	
	}

	@Test
	public void Nで始まる名前を抽出(){
		
		assertThat(new PickingAnElement(friends).pickName_BeforeJava8("N"), is("Nate"));	
		assertThat(new PickingAnElement(friends).pickName_BeforeJava8("0"), is(""));	
	}

	

}
