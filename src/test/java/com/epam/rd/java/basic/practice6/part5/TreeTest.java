package com.epam.rd.java.basic.practice6.part5;

import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void addTest1(){
        Tree<Integer> tree = new Tree<>();
        tree.add(3);
        Assert.assertTrue(tree.add(4));
    }

    @Test
    public void addTest2(){
        Tree<Integer> tree = new Tree<>();
        tree.add(3);
        Assert.assertFalse(tree.add(3));
    }

    @Test
    public void testMain(){
        Part5.main(null);
        Assert.assertTrue(true);
    }
    
}
