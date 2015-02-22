package com.slgerkamp.fpij.chapter04;

import java.util.List;
import java.util.function.Predicate;

/**
 * 資産のユーティリティクラス
 *
 */
public class AssertUtil {

	/**
	 * 資産の合計
	 * 主要な関心の分離を行うため、関数を受け取る高階関数に
	 * 
	 * @param assets：計算対象の資産
	 * @return assetSelector：合計する資産の対象
	 */
	public static int totalAssetValues(final List<Asset> assets, final Predicate<? super Asset> assetSelector){
		
		int total = assets.stream()
				.filter(assetSelector)
				.mapToInt(Asset::getValue).sum();		
	
		return total;
	}
}
