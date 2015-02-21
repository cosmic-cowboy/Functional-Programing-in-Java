package com.slgerkamp.fpij.chapter01;

import java.math.BigDecimal;
import java.util.List;

public class Prices {

	final List<BigDecimal> prices;

	public Prices(List<BigDecimal> prices) {
		this.prices = prices;
	}

	/**
	 * 関数型を使って、
	 * 20ドル以上の値段を抽出して、値引き後の合計金額を計算する
	 * @return
	 */
	public BigDecimal discountFunctional(){
		// filter:20ドルより高い商品をフィルタリング
		// map:対象に×0.9
		// reduce:対象の値を集約
		BigDecimal total = prices.stream()
			.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
			.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return total;
	}

	/**
	 * 命令型で
	 * 20ドル以上の値段を抽出して、値引き後の合計金額を計算する
	 * @return
	 */
	public BigDecimal discountImperative(){
		BigDecimal total = BigDecimal.ZERO;
		for(BigDecimal price : prices){
			if(price.compareTo(BigDecimal.valueOf(20)) > 0){
				total = total.add(price.multiply(BigDecimal.valueOf(0.9)));
			}
		}
		return total;
		
	}

}
