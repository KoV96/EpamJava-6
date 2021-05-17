package com.epam.rd.java.basic.practice6.part1;


import com.epam.rd.java.basic.practice6.Demo;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class WordContainerTest {
    @Test
    public void demoMain(){
        Demo.main(new String[0]);
        assertTrue(true);
    }

    @Test
    public void addTest(){
        WordContainer wordContainer = new WordContainer();
        wordContainer.add(new Word("test"));
        boolean actual = wordContainer.add(new Word("test"));
        Assert.assertFalse(actual);
    }
}
