package com.slgerkamp.fpij.chapter04;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * 4章 ラムダ式で設計する
 * 
 * 4.2 ラムダ式を使った委譲
 * Delegating using Lambda Expressions
 *
 */
public class CalculateByDelegate {

	// 株価情報
	// 株式銘柄コードを与えるとWebサービスから株価を取得する
	private Function<String, BigDecimal> priceFinder;

	/**
	 * コンストラクタ
	 * 
	 * 株価情報を引数として持つことで、責任の一部をラムダ式に委譲。
	 * クラスからの関心の分離を行っている。
	 * 依存性の注入、依存関係逆転の原則を使っている。
	 * これによりコードが拡張可能となる
	 * 
	 * @param priceFinder:株価情報
	 */
	public CalculateByDelegate(Function<String, BigDecimal> priceFinder) {
		this.priceFinder = priceFinder;
	}
	
	/**
	 * 価格と保有株数から合計資産額を計算
	 * 
	 * @param ticker
	 * @param shares
	 * @return
	 */
	public BigDecimal computeStockWorth(final String ticker, final int shares){
		
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}
	
	
}
