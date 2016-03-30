package com.epam.vasylieva.practice6.part3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Part3Test {

	@Test
	public void charTest() {
		Part3 p = new Part3();
		String actual = p.getLiterals("a bcd 43.43 432 и л фвыа 89 .98", "char");
		String expected = "a и л ";
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void stringTest() {
		Part3 p = new Part3();
		String actual = p.getLiterals("a bcd 43.43 432 и л фвыа 89 .98", "String");
		String expected = "bcd фвыа ";
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void intTest() {
		Part3 p = new Part3();
		String actual = p.getLiterals("a bcd 43.43 432 и л фвыа 89 .98", "int");
		String expected = "432 89 ";
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void doubleTest() {
		Part3 p = new Part3();
		String actual = p.getLiterals("a bcd 43.43 432 и л фвыа 89 .98", "double");
		String expected = "43.43 .98 ";
		Assert.assertEquals(expected, actual);
	}

}
