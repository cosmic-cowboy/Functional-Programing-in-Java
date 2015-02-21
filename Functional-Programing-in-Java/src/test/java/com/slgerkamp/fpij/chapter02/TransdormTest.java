package com.slgerkamp.fpij.chapter02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TransdormTest {

	final static List<String> UPPERFREINDS = 
		    Arrays.asList("BRIAN", "NATE", "NEAL", "RAJU", "SARA", "SCOTT");
	
	@Test
	public void  List内の文字列を大文字に統一_forEach(){
		final List<String> friends = 
			    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		Transform transform = new Transform(friends);
		
		assertThat(transform.upperWithForEach(), is(UPPERFREINDS));		
	}

	@Test
	public void List内の文字列を大文字に統一_ラムダ式(){
		final List<String> friends = 
			    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		Transform transform = new Transform(friends);
		
		assertThat(transform.upperWithLambda(), is(UPPERFREINDS));		
	}


}
