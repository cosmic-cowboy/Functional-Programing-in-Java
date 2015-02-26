package com.slgerkamp.fpij.chapter05;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 5章　外部リソースを扱う
 * 5.1 リソースの解放
 *
 */
public class FileWriter_autoclose implements AutoCloseable{

	private final FileWriter writer;

	public FileWriter_autoclose(final String fileName) throws IOException {

		this.writer = new FileWriter(fileName);
	}
	
	public void writeStuff(String message) throws IOException{
		writer.write(message);
	}

	@Override
	public void close() throws Exception {
			writer.close();
	}
	

}
