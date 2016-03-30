package com.epam.vasylieva.practice6.part2;

import com.epam.vasylieva.practice4.part1.FileParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Part2 {

	private static final String FILE_NAME = "part2.txt";

	private static final String FILE_NAME2 = "part2_sorted.txt";

	private static final int N = 20;

	private static final int MAX = 50;

	public static void main(String[] args) {
		Part2 p = new Part2();
		p.create(p.createContent(), FILE_NAME);
		System.out.println("input ==> "+p.read());
		String sorted = p.sort(p.read());
		p.create(sorted, FILE_NAME2);
		System.out.println("output ==> "+sorted);
	}

	public void create(String content, String fileName){
		File file = new File("src/resources/"+fileName);
		try (FileOutputStream fop = new FileOutputStream(file)) {

			if (!file.exists()) {
				file.createNewFile();
			}

			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();

		} catch (IOException e) {
			System.out.println("Some problems with file creating:" + e.getMessage());
		}
	}

	public String createContent(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<10; i++){
			sb.append((int)(Math.random() * 51)).append(" ");
		}
		return sb.toString();
	}

	public String read(){
		String s = "";
		try {
			s = new String(Files.readAllBytes(Paths.get("src/resources/"+FILE_NAME)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Some problems with file reading:" + e.getMessage());
		}
		return s;
	}

	public String sort(String s){
		boolean swapped = true;
		double j = 0;
		String[] arrS = s.split(" ");
		int [] arr = new int[arrS.length];
		for(int i = 0; i<arr.length; i++){
			arr[i] = Integer.parseInt(arrS [i]);
		}

		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i]>arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<arr.length; i++){
			sb.append(arr[i]).append(" ");
		}
		return sb.toString();
	}


}