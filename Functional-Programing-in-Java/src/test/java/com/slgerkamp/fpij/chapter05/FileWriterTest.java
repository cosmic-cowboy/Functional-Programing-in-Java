package com.slgerkamp.fpij.chapter05;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * 5章　外部リソースを扱う
 * 5.1 リソースの解放
 * 5.2 ラムダ式でリソース解放
 *
 */
public class FileWriterTest {

	final static String FILENAME_01 = "peekaboo_01.txt";
	final static String FILENAME_02 = "peekaboo_02.txt";
	final static String FILENAME_03 = "peekaboo_03.txt";
	final static String FILENAME_04 = "peekaboo_04.txt";
	final static String MESSAGE = "peek-a-boo";
	
	@Test
	public void リソースが閉じられていない() throws IOException{
		final FileWriter_no_close writer = new FileWriter_no_close(FILENAME_01);
		writer.writeStuff(MESSAGE);
		writer.finalize();
		// 閉じられていない確認方法がわからない
		assertThat(readFile(FILENAME_01), is(MESSAGE));		
	}

	@Test
	public void リソースを閉じる() throws IOException{
		
		final FileWriter_close writer = new FileWriter_close(FILENAME_02);
		try {
			writer.writeStuff(MESSAGE);
		} finally {
			writer.close();			
		}
		
		assertThat(readFile(FILENAME_02), is(MESSAGE));		
	}

	@Test
	public void AutoCloseableを利用してリソースを閉じる() throws IOException, Exception{

		try(FileWriter_autoclose writer = new FileWriter_autoclose(FILENAME_03);) {
			writer.writeStuff(MESSAGE);	
		}
		
		assertThat(readFile(FILENAME_03), is(MESSAGE));			
	}

	@Test
	public void 高階関数を利用してリソースを閉じる() throws IOException, Exception{

		FileWriter_using_high_order_function.use(FILENAME_04, 
				writer -> writer.writeStuff(MESSAGE));
		
		assertThat(readFile(FILENAME_04), is(MESSAGE));			
	}


	
	private static String readFile(final String fileName) throws FileNotFoundException, IOException{
		try(BufferedReader reader = 
				new BufferedReader(new FileReader(fileName))){
			final String actual = 
					reader.lines().findFirst().get();
			return actual;
		}

	}
}
