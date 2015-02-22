package com.slgerkamp.fpij.chapter03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * 3.5 ディレクトリの全ファイルをリスト
 * 3.6 ディレクトリの特定のファイルだけをリスト
 */
public class FileTest {

	final static String [] pathArray = {"./.classpath","./.gitignore","./.project","./.settings","./pom.xml","./src","./target"};
	final static List<String> expectedPathlist = Arrays.asList(pathArray);

	final static String [] dirArray = {"./.settings","./src","./target"};
	final static List<String> expectedDirlist = Arrays.asList(dirArray);
	
	
	@Test
	public void ルートディレクトリ配下のディレクトリとファイルを取得する() throws IOException{
		List<String> fileList = Files.list(Paths.get("."))
				.map(Path::toString)
				.collect(toList());
		
		assertThat(fileList, is(expectedPathlist));	
	}
	
	@Test
	public void ルートディレクトリ配下のディレクトリを取得する() throws IOException{
		List<String> fileList = Files.list(Paths.get("."))
				.filter(Files::isDirectory)
				.map(Path::toString)
				.collect(toList());
		
		assertThat(fileList, is(expectedDirlist));	
	}
	
	@Test
	public void ルートディレクトリ配下の特定のファイルを取得する() throws IOException{
		List<String> fileList = Files.list(Paths.get("."))
				.filter(path -> path.toString().endsWith("ignore"))
				.map(Path::toString)
				.collect(toList());
		
		assertThat(fileList, is(Collections.singletonList("./.gitignore")));	
	}
	
	@Test
	public void ルートディレクトリ配下の特定のファイルを取得する_newDirectoryStream() throws IOException{
		List<String> fileList = new ArrayList<>();
			Files.newDirectoryStream(
				Paths.get("."), path -> path.toString().endsWith("ignore")
			).forEach(path -> fileList.add(path.toString()));
		
		assertThat(fileList, is(Collections.singletonList("./.gitignore")));	
	}
}
