package com.epam.vasylieva.practice6.part2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Part2Test {
	private static final Part2 p = new Part2();
	@Test
	public void createContentTest() {
		String actual = p.createContent();
		Assert.assertNotNull(actual);
	}
    @Test
    public void createTest(){
        p.create("30 23 16 16 9 23 3 18 21 29","part2_test.txt");
    }
    @Test
    public void sortTest(){
        String actual = p.sort(p.read("part2_test.txt"));
        String expected = "3 9 16 16 18 21 23 23 29 30 ";
        Assert.assertEquals(expected, actual);

    }

}
