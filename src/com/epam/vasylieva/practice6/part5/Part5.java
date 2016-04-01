package com.epam.vasylieva.practice6.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Part5 {

	private static final String BASE_NAME = "resources";

	public static void main(String[] args) {
		Part5 p = new Part5();
        String decision;
        ArrayList<String[]> pairs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((decision = br.readLine())!=null)
                pairs.add(decision.split(" "));

        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String[] el : pairs){
            try {
                String res = p.readKey(el[0], el[1]);
                System.out.print(res+" ");
            }catch (RuntimeException e){
                System.out.println("Sorry, type is invalid.");
            }
        }
	}

	public String readKey(String key, String localeName){
		Locale locale = new Locale(localeName);
		ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
		return bundle.getString(key);
	}

}