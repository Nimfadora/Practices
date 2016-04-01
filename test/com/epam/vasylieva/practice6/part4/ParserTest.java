package com.epam.vasylieva.practice6.part4;


import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParserTest {
    private static final Parser p = new Parser("part4.txt", "Cp1251");
    private static final Iterator i = p.iterator();

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove(){
        i.remove();
    }
    @Test(expected = NoSuchElementException.class)
    public void testNext(){
        while (i.hasNext())
            i.next();
        i.next();
    }
}
