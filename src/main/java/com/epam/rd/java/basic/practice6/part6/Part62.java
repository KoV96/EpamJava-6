package com.epam.rd.java.basic.practice6.part6;

import java.util.*;

public class Part62 {
    private final String[] input;
    Map<String, Integer> map = new LinkedHashMap<>();

    public Part62 (String[] input){
        this.input = input;
    }

    private void getLength(){
        for (String word : input){
            map.put(word, word.length());
        }
    }

    public String getResult(){
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getLength();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).forEach(x -> arr.add(x.getKey() + " ==> " + x.getValue()));
        for (int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i));
            if (i != arr.size() - 1){
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
