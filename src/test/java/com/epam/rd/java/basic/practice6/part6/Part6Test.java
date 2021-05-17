package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Part6Test {

    @Test
    public void demoMain(){
        Demo.main(new String[0]);
        assertTrue(true);
    }

    @Test
    public void partMainFreq(){
        String[] args = {"--input", "part6.txt", "--task", "frequency"};
        Part6.main(args);
        Assert.assertTrue(true);
    }

    @Test
    public void partMainLength(){
        String[] args = {"--input", "part6.txt", "--task", "length"};
        Part6.main(args);
        Assert.assertTrue(true);
    }

    @Test
    public void partMainDuplicates(){
        String[] args = {"--input", "part6.txt", "--task", "duplicates"};
        Part6.main(args);
        Assert.assertTrue(true);
    }
}
