package com.slgerkamp.fpij.chapter04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Function;

import org.junit.Test;

/**
 * 4章 ラムダ式で設計する
 * 
 * 4.2 ラムダ式を使った委譲
 * Delegating using Lambda Expressions
 *
 */
public class CalculateByDelegateTest {
	
	@Test
	public void 保有資産を計算する() throws IOException{
		// 期待値
		BigDecimal expected = new BigDecimal("6010.00");
		
		// 計算
		Function<String, BigDecimal> priceFinder = ticker -> new BigDecimal("6.01");
		CalculateByDelegate stockCalculate = new CalculateByDelegate(priceFinder);
		BigDecimal stock = stockCalculate.computeStockWorth("GOOG", 1000);
		
		// 確認
		assertThat(stock, is(expected));

	}

	
	@Test
	public void 最新の株価情報を取得し現在の保有資産を計算する() throws IOException{
		// 期待値（2015-02-23）
		BigDecimal expected = new BigDecimal("538950.00");
		
		// 計算
		CalculateByDelegate stockCalculate = new CalculateByDelegate(YahooFinance::getPrice);
		BigDecimal stock = stockCalculate.computeStockWorth("GOOG", 1000);
		
		// 確認
		assertThat(stock, is(expected));

	}

}
