package com.slgerkamp.fpij.chapter04;

import java.util.List;

/**
 * 資産のユーティリティクラス
 *
 */
public class AssertUtil {

	public static int totalAssetValues(final List<Asset> assets){
		
		int total = assets.stream().mapToInt(Asset::getValue).sum();		
	
		return total;
	}

}
