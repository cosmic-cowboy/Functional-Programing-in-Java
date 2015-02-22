package com.slgerkamp.fpij.chapter04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import com.slgerkamp.fpij.chapter04.Asset.AssetType;

/**
 * 4章-1 ラムダ式を使った関心の分離
 *
 */
public class AssetTest {

	static List<Asset> assets = Arrays.asList(
				new Asset(AssetType.BOND, 1000),
				new Asset(AssetType.BOND, 2000),
				new Asset(AssetType.STOCK, 3000),
				new Asset(AssetType.STOCK, 4000)
			
			);
	
	@Test
	public void 資産を合計する() throws IOException{
		
		// すべての資産を対象としているので常に述語の戻り値がtrue
		final Predicate<Asset> all = asset -> true;
		int total = AssertUtil.totalAssetValues(assets, all);
		assertThat(total, is(10000));	
	}

	
	@Test
	public void 資産の中のBONDの合計() throws IOException{
		
		final Predicate<Asset> bondSelector = asset -> asset.getType().equals(AssetType.BOND);
		int total = AssertUtil.totalAssetValues(assets, bondSelector);
		assertThat(total, is(3000));	
	}

	
	@Test
	public void 資産の中のSTOCKの合計() throws IOException{
		
		final Predicate<Asset> stockSelector = asset -> asset.getType().equals(AssetType.STOCK);
		int total = AssertUtil.totalAssetValues(assets, stockSelector);
		assertThat(total, is(7000));	
	}
}
