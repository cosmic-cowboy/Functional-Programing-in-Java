package com.slgerkamp.fpij.chapter01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

public class PricesTest {


	@Test
	public void 値段が20ドル以上の商品が1割値引きされている_命令型(){
		Prices prices = new Prices(Arrays.asList(
								new BigDecimal("10"), new BigDecimal("12"), new BigDecimal("15"),
								new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("30"),
								new BigDecimal("45")
						));
		
		assertThat(prices.discountImperative(), is(new BigDecimal("67.5")));		
	}

	@Test
	public void 値段が20ドル以上の商品が1割値引きされている_関数型(){
		Prices prices = new Prices(Arrays.asList(
				new BigDecimal("10"), new BigDecimal("12"), new BigDecimal("15"),
				new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("30"),
				new BigDecimal("45")
		));

		assertThat(prices.discountFunctional(), is(new BigDecimal("67.5")));		
	}

}
