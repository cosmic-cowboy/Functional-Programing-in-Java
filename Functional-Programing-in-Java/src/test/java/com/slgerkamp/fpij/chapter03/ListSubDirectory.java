package com.slgerkamp.fpij.chapter03;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 3.7 flatMapで直下のサブディレクトリをリスト
 *
 */
public class ListSubDirectory {
	
	@Test
	public void ルートディレクトリ配下のディレクトリとファイルを取得する() throws IOException{
		List<File> fileList = 
				Stream.of(new File(".").listFiles())
				.flatMap(file -> file.listFiles() == null ? Stream.of(file) :  Stream.of(file.listFiles()))
				.collect(toList());
		
		assertThat(fileList.size(), is(11));	
	}
}
