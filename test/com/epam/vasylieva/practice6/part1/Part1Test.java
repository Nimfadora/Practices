package com.epam.vasylieva.practice6.part1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void test() {
		Part1 p = new Part1();
		String actual = p.convert("в огромном городе моем - ночь.\n" +
				"из дома сонного иду - прочь.\n" +
				"who shall say that Fortune grieves him");
		String expected = "в ОГРОМНОМ ГОРОДЕ МОЕМ - НОЧЬ.\n" +
				"из ДОМА СОННОГО иду - ПРОЧЬ.\n"+
				"who SHALL say THAT FORTUNE GRIEVES him";
		Assert.assertEquals(expected, actual);
	}

}
