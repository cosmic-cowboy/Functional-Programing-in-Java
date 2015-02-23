package com.slgerkamp.fpij.chapter04;

import java.awt.Color;
import java.util.function.Function;

/**
 * 4章 ラムダ式で設計する
 * 4.3 ラムダ式を使ったデコレーション
 *
 * ひとつのフィルターを適用するカメラ
 */
public class SingleFilterCamera {

	// フィルター
	private Function<Color, Color> filter;

	/**
	 * コンストラクタ
	 * @param filter
	 */
	public SingleFilterCamera() {
		super();
		this.filter = (color -> color);
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

	/**
	 * 単独フィルターをセットする
	 * @param filter
	 */
	public void setFilter(final Function<Color, Color> filter) {
		this.filter = filter;
	}


	
	
}
