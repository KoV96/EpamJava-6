package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        System.out.println("ArrayList#Index: " + removeByIndex(createCircleArray(10000), 4) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(createCircleLinked(10000), 4) + " ms");
        System.out.println("ArrayList#Iterator: " + removeByIterator(createCircleArray(10000), 4) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(createCircleLinked(10000), 4) + " ms");

    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long start = System.currentTimeMillis();
        int pos = 0;
        while (list.size() != 1) {
            pos = (pos + k - 1) % list.size();
            list.remove(pos);
        }
        return System.currentTimeMillis() - start;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long start = System.currentTimeMillis();
        int pos = 0;
        Iterator<Integer> iterator = list.iterator();
        while (list.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                pos++;
                if (pos == k) {
                    iterator.remove();
                    pos = 0;
                }
            } else {
                iterator = list.iterator();
            }
        }
        return System.currentTimeMillis() - start;
    }

    public static List<Integer> createCircleArray(int capacity) {
        List<Integer> array = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            array.add(i);
        }
        return array;
    }

    public static List<Integer> createCircleLinked(int capacity) {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }
}
