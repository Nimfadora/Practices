package com.epam.vasylieva.practice6.part5;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Part5Test {

    @Test
    public void test() throws IOException {
        System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru".getBytes("Cp1251")));
        System.setOut(new PrintStream("src/resources/part5_test.txt", "Cp1251"));
        Part5.main(new String[]{});
        String s =
                new String(Files.readAllBytes(Paths.get("src/resources/" + "part5_test.txt")), "Cp1251");
        Assert.assertEquals("стол table яблоко ", s);

    }

}
