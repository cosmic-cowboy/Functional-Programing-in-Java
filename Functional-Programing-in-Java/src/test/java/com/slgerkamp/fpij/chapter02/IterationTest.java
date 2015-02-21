package com.slgerkamp.fpij.chapter02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class IterationTest {

	
	@Test
	public void Listの詰め直し_Consumerインスタンス(){
		final List<String> friends = 
			    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		Iteration iteration = new Iteration(friends);
		
		assertThat(iteration.addWithConsumerInstance(), is(friends));		
	}

	@Test
	public void Listの詰め直し_ラムダ式(){
		final List<String> friends = 
			    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		Iteration iteration = new Iteration(friends);
		
		assertThat(iteration.addWithLambda(), is(friends));		
	}


}
