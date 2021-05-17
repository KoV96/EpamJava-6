package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer>{
    private int firstBound;
    private int secondBound;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        this.firstBound = firstBound;
        this.secondBound = secBound;
        if (reversedOrder){
            this.firstBound = secBound;
            this.secondBound = firstBound;
        }
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }
    
    private final class IteratorImpl implements Iterator<Integer> {
        int counter = Math.abs(secondBound - firstBound);
        int current = firstBound;
        boolean isReversed = firstBound > secondBound;

        @Override
        public boolean hasNext() {
            return counter >= 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            int next = current;
            if (isReversed) {
                current--;
            } else {
                current++;
            }
            counter--;
            return next;
        }
        
    }

}
