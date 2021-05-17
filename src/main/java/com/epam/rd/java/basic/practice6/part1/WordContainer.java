package com.epam.rd.java.basic.practice6.part1;

import java.util.*;

public class WordContainer extends TreeSet<Word> {

    @Override
    public boolean add(Word word) {
        if (!this.contains(word)) {
            super.add(word);
            return true;
        }
        for (Word wc : this) {
            if (wc.equals(word)) {
                wc.setFrequency(wc.getFrequency() + 1);
                break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.size() == 0) {
            return "[]";
        }
        TreeSet<Word> sf = new TreeSet<>((o1, o2) -> {
            int compare = -Integer.compare(o1.getFrequency(), o2.getFrequency());
            if (compare == 0) {
                return (o1.hashCode() - o2.hashCode());
            }
            return compare;
        });
        sf.addAll(this);
        for (Word word : sf) {
            sb.append(word.toString());
            if (!word.equals(sf.last())) sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WordContainer wordContainer = new WordContainer();
        Scanner sc = new Scanner(System.in);
        boolean isStopped = false;
        while (!isStopped) {
            String line = sc.nextLine();
            String[] lineByWords = line.split(" ");
            if (line.equalsIgnoreCase("stop")) {
                break;
            }
            for (String word : lineByWords) {
                if (word.equalsIgnoreCase("stop")) {
                    isStopped = true;
                    break;
                }
                wordContainer.add(new Word(word));
            }
        }
        System.out.println(wordContainer);
    }

}
