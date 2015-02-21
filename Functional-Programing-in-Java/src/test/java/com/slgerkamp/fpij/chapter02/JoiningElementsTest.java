package com.slgerkamp.fpij.chapter02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class JoiningElementsTest {

	public static final List<String> friends = 
	    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	public static final List<String> editors = 
	    Arrays.asList("Brian", "Jackie", "John", "Mike");
	public static final List<String> comrades =                      
	    Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	
	@Test
	public void 文字列連結(){
		
		assertThat(new JoiningElements(friends).join(), is("Brian, Nate, Neal, Raju, Sara, Scott"));	
	}


}
