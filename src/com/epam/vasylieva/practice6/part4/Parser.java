package com.epam.vasylieva.practice6.part4;

import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser implements Iterable<String> {
	private String fileName;
	private String encoding;

	private class SentenceIterator implements Iterator<String>{
		String text = read();
		Pattern p = Pattern.compile("([A-ZА-Я](.|\n)*?\\.)", Pattern.MULTILINE);
		Matcher m = p.matcher(text);
		int current = 0;

		@Override
		public boolean hasNext() {
			return m.find();
		}
		@Override
		public String next() {
			if ( m.find(current)) {
				current +=m.group().length();
				return m.group().replace('\n', ' ');
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public Parser(String fileName, String encoding) {
		this.fileName = fileName;
		this.encoding = encoding;
	}

	private String read(){
		String s = "";
		try {
			s = new String(Files.readAllBytes(Paths.get("src/resources/"+fileName)), encoding);
		} catch (IOException e) {
			System.out.println("Some problems with file reading:" + e.getMessage());
		}
		return s;
	}

	@Override
	public Iterator<String> iterator() {
		return new SentenceIterator();
	}

}