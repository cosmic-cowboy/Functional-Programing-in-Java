package com.slgerkamp.fpij.chapter03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

/**
 * 3.8 ファイルの変更を監視
 */
public class WatchFileChangeTest {
	
	/**
	 * 
	 * テストを実行したらpomファイルに改行を入れる
	 */
	@Test
	public void ルートディレクトリを20秒監視_pomファイルを修正(){
		
		Optional<List<String>> eventList = WatchFileChange.set(".");
		
		assertThat(eventList.get().size(), is(1));
		
		
	}

}
