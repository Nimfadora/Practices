package com.epam.vasylieva.practice6.part3;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	public static final String FILE_NAME = "part3.txt";

	public static void main(String[] args) {
		Part3 p = new Part3();
		String decision;
		ArrayList<String> types = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while ((decision = br.readLine())!=null)
				types.add(decision);

		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String type : types){
			try {
				String res = p.getLiterals(p.read(), type);
				System.out.println(res);
			}catch (RuntimeException e){
				System.out.println("Sorry, type is invalid.");
			}
		}

	}

	public String getLiterals(String text, String type){
		Pattern p;
		switch (type){
			case "int":
				p = Pattern.compile("(?:(?:^|\\s)(\\d+)($|\\s))");
				break;
			case "char":
				p = Pattern.compile("(?:(?:^|\\s)([a-zA-Zа-яА-Я])(?=\\s))", Pattern.MULTILINE);
				break;
			case "double":
				p = Pattern.compile("(?:(?:^|\\s)(\\d*(?:,|\\.)\\d+)|(\\d+(?:,|\\.)\\d*)($|\\s))", Pattern.MULTILINE);
				break;
			case "String":
				p = Pattern.compile("(?:(?:^|\\s)([a-zA-Zа-яА-Я]{2,})($|\\s))");
				break;
			default:
				throw new RuntimeException();
		}
		Matcher m = p.matcher(text);
		StringBuffer sb = new StringBuffer();

		while (m.find())
			sb.append(m.group(1)).append(" ");
		return sb.toString();
	}

	private String read(){
		String s = "";
		try {
			s = new String(Files.readAllBytes(Paths.get("src/resources/"+FILE_NAME)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Some problems with file reading:" + e.getMessage());
		}
		return s;
	}

}