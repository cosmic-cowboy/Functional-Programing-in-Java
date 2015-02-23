package com.slgerkamp.fpij.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

/**
 * Yahoo Financeの株価情報を扱うクラス
 *
 */
public class YahooFinance {
	
	
	/**
	 * Yahoo financeに問い合わせて、株価を取得する
	 * @param ticker
	 * @return
	 */
	public static BigDecimal getPrice(final String ticker){
		try {
			// yahoo financeに問い合わせ
			final URL url = 
					new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
			final BufferedReader reader = 
					new BufferedReader(new InputStreamReader(url.openStream()));
			
			// 入力値を1行ずつ返すStreamを利用
			// 1行スキップして、次にレコードを取得
			final String data = 
					reader.lines().skip(1).findFirst().get();
			
			// レコードはカンマ区切りで株価情報が記述されているので、項目ごとに格納
			final String [] dataItems = data.split(",");
			// 株価情報の最後のカラムに株価が格納されている
			return new BigDecimal(dataItems[dataItems.length - 1]);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
