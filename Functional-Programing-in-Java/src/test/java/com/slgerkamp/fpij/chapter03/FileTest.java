package com.slgerkamp.fpij.chapter03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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

}
