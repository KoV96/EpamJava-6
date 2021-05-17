package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Part63{
    private final String[] input;
    Map<String, Integer> map = new LinkedHashMap<>();

    public Part63 (String[] input){
        this.input = input;
    }

    private void getMap(){
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
        getMap();
        ArrayList<String> arr = new ArrayList<>();
        map.entrySet().stream().filter(x -> x.getValue() > 1).limit(3)
                .forEach(x -> arr.add((new StringBuilder().append(x.getKey().toUpperCase()).reverse()).toString()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i));
            if (i != arr.size() - 1){
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
