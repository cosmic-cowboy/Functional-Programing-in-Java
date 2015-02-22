package com.slgerkamp.fpij.chapter04;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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
		
		int total = AssertUtil.totalAssetValues(assets);
		assertThat(total, is(10000));	
	}
}
