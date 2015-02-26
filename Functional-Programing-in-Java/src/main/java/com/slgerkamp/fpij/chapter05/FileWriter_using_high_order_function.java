package com.slgerkamp.fpij.chapter05;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 5章　外部リソースを扱う
 * 5.2 ラムダ式でリソース解放
 *
 */
public class FileWriter_using_high_order_function {

	private final FileWriter writer;

	private FileWriter_using_high_order_function(final String fileName) throws IOException {

		this.writer = new FileWriter(fileName);
	}
	
	public void writeStuff(String message) throws IOException{
		writer.write(message);
	}

	private void close() throws Exception {
			writer.close();
	}
	
	public static void use(final String fileName, 
			final UseInstance<FileWriter_using_high_order_function, IOException> block) throws Exception{
		final FileWriter_using_high_order_function fileWriter = new FileWriter_using_high_order_function(fileName);
		
		try {
			block.accept(fileWriter);
		} finally {
			fileWriter.close();
		}
	}
}
