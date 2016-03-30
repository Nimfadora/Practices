package com.epam.vasylieva.practice6;

import com.epam.vasylieva.practice6.part1.Part1Test;
import com.epam.vasylieva.practice6.part2.Part2Test;
import com.epam.vasylieva.practice6.part3.Part3Test;
import com.epam.vasylieva.practice6.part4.Part4Test;
import com.epam.vasylieva.practice6.part5.Part5Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Part1Test.class, Part2Test.class, Part3Test.class,
		Part4Test.class, Part5Test.class })
public class AllTests {
}
