package com.slgerkamp.fpij.chapter04;

import java.util.List;

import com.slgerkamp.fpij.chapter04.Asset.AssetType;

/**
 * 資産のユーティリティクラス
 *
 */
public class AssertUtil {

	/**
	 * 資産の合計
	 * @param assets
	 * @return
	 */
	public static int totalAssetValues(final List<Asset> assets){
		
		int total = assets.stream().mapToInt(Asset::getValue).sum();		
	
		return total;
	}

	/**
	 * 資産の中のSTOCKの合計
	 * @param assets
	 * @return
	 */
	public static int totalSTOCKValues(final List<Asset> assets){
		
		int total = assets.stream()
				.filter(asset -> asset.getType().equals(AssetType.STOCK))
				.mapToInt(Asset::getValue).sum();		
	
		return total;
	}

	/**
	 * 資産の中のBONDの合計
	 * @param assets
	 * @return
	 */
	public static int totalBONDValues(final List<Asset> assets){
		
		int total = assets.stream()
				.filter(asset -> asset.getType().equals(AssetType.BOND))
				.mapToInt(Asset::getValue).sum();		
	
		return total;
	}

}
