package com.slgerkamp.fpij.chapter01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class CitiesTest {

	private static final String CHICAGO = "chicago";

	@Test
	public void chicagoが存在する_命令型(){
		Cities cities = new Cities(Arrays.asList("chicago", "newyork", "boston"));
		assertThat(cities.containsByImperative(CHICAGO), is(true));		
	}

	@Test
	public void chicagoが存在する_宣言型(){
		Cities cities = new Cities(Arrays.asList("chicago", "newyork", "boston"));
		assertThat(cities.containsByImperative(CHICAGO), is(true));		
	}

}
