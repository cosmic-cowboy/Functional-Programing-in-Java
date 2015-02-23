package com.slgerkamp.fpij.chapter04;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 4章 ラムダ式で設計する
 * 4.3 ラムダ式を使ったデコレーション
 *
 */
public class MultiFilterCamera {

	// フィルター
	private Function<Color, Color> filter;

	/**
	 *  コンストラクタ
	 */
	@SuppressWarnings("unchecked")
	public MultiFilterCamera() {
		setFilters();
	}


	/**
	 * フィルターをセットする
	 * @param filter
	 */
	public void setFilters(@SuppressWarnings("unchecked") final Function<Color, Color>... filters) {
		this.filter = Stream.of(filters)
				.reduce((filter, next) -> filter.compose(next))
				// 与えられた引数をそのまま返す
//				.orElse(color -> color)
				// 与えられた引数をそのまま返す staticメソッド
				.orElseGet(Function::identity);
	}


	/**
	 * 撮影する
	 * @param inputColor
	 * @return
	 */
	public Color capture(final Color inputColor){
		// フィルター関数の実行
		final Color processedColor = filter.apply(inputColor);
		return processedColor;
	}


	
	
}
