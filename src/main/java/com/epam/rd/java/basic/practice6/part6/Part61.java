package com.epam.rd.java.basic.practice6.part6;

import java.util.*;

public class Part61{
    private final String[] input;
    Map<String, Integer> map = new LinkedHashMap<>();

    public Part61 (String[] input){
        this.input = input;
    }

    public void getFrequency(){
        for (String word : input){
            if (map.containsKey(word)){
                int currentFrequency = map.get(word);
                map.put(word, currentFrequency + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    public String getResult(){
        Map<String, Integer> res = new LinkedHashMap<>();
        List<String> arr = new ArrayList<>();
        getFrequency();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).forEach(x -> res.put(x.getKey(), x.getValue()));
        StringBuilder sb = new StringBuilder();
        res.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(x -> arr.add(x.getKey() + " ==> " + x.getValue()));
        for (int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i));
            if (i != arr.size() - 1){
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
