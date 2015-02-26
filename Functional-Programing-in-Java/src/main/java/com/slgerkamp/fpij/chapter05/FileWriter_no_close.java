package com.slgerkamp.fpij.chapter05;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 5章　外部リソースを扱う
 * 5.1 リソースの解放
 *
 */
public class FileWriter_no_close {

	private final FileWriter writer;

	public FileWriter_no_close(final String fileName) throws IOException {

		this.writer = new FileWriter(fileName);
	}
	
	public void writeStuff(String message) throws IOException{
		writer.write(message);
	}
	
	public void finalize() throws IOException{
		writer.close();
	}
}
