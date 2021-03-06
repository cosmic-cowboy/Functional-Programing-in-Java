package com.slgerkamp.fpij.chapter04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;

import org.junit.Test;

/**
 * 4章 ラムダ式で設計する
 * 4.3 ラムダ式を使ったデコレーション
 *
 */
public class CameraTest {

	@Test
	public void ひとつのフィルターを適用する(){

		// 期待値
		Color expectedColor = new Color(255,142,255);
		
		SingleFilterCamera camera = new SingleFilterCamera();
		camera.setFilter(Color::brighter);
		Color filteredColor = camera.capture(new Color(200, 100, 200));

		assertThat(filteredColor, is(expectedColor));	
	}


	@SuppressWarnings("unchecked")
	@Test
	public void 複数のフィルターを適用する(){

		// 期待値
		Color expectedColor = new Color(255,202,255);
		
		// フィルターを適用
		// 本来はコンストラクタで設定してしまうのが、漏れがなくて良い
		MultiFilterCamera camera = new MultiFilterCamera();
		camera.setFilters(Color::brighter, Color::brighter);
		Color filteredColor = camera.capture(new Color(200, 100, 200));

		assertThat(filteredColor, is(expectedColor));
	}


	@Test
	public void フィルターを適用しない(){

		// 期待値
		Color expectedColor = new Color(200, 100, 200);
		
		// フィルターを適用
		// 本来はコンストラクタで設定してしまうのが、漏れがなくて良い
		MultiFilterCamera camera = new MultiFilterCamera();
		Color filteredColor = camera.capture(new Color(200, 100, 200));

		assertThat(filteredColor, is(expectedColor));	
	}

}
