package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Part2Test {
    @Test
    public void testTimeIndex(){
        List<Integer> arr = Part2.createCircleArray(10000);
        List<Integer> linkedList = Part2.createCircleLinked(10000);
        long arrIndex = Part2.removeByIndex(arr, 4);
        long linkedIndex = Part2.removeByIndex(linkedList, 4);
        Assert.assertTrue(arrIndex < linkedIndex);
    }

    @Test
    public void testTimeIterator(){
        List<Integer> arr = Part2.createCircleArray(10000);
        List<Integer> linkedList = Part2.createCircleLinked(10000);
        long arrIndex = Part2.removeByIterator(arr, 4);
        long linkedIndex = Part2.removeByIterator(linkedList, 4);
        Assert.assertTrue(arrIndex > linkedIndex);
    }

    @Test
    public void testMain(){
        Part2.main(null);
        Assert.assertTrue(true);
    }
    
}