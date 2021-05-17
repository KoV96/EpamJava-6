package com.epam.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

    private final String content;
    private int frequency;

    public Word(String inputWord) {
        this.content = inputWord;
        this.frequency = 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word1 = (Word) o;
        return content.equals(word1.content);
    }

    @Override
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }

    @Override
    public int compareTo(Word word) {
        return this.hashCode() - word.hashCode();
    }

}
