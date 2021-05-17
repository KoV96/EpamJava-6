package com.epam.rd.java.basic.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final List<Integer> parkZone;
    private static final int EMPTY = 0;
    private static final int BUSY = 1;

    public Parking(int capacity) {
        parkZone = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            parkZone.add(EMPTY);
        }
    }

    public boolean arrive(int k) {
         if (k >= parkZone.size()) throw new IllegalArgumentException();
        if (parkZone.get(k) == EMPTY) {
            parkZone.set(k, BUSY);
            return true;
        }
        for (int i = k + 1; i < parkZone.size(); i++) {
            if (parkZone.get(i) == EMPTY) {
                parkZone.set(i, BUSY);
                return true;
            }
        }
        for (int i = 0; i < k; i++) {
            if (parkZone.get(i) == EMPTY) {
                parkZone.set(i, BUSY);
                return true;
            }
        }
        return false;
    }

    public boolean depart(int k) {
        if (k >= parkZone.size()) throw new IllegalArgumentException();
        if (parkZone.get(k) == BUSY){
            parkZone.set(k, EMPTY);
            return true;
        }
        return false;
    }

    public void print() {
        for (Integer value : parkZone){
            System.out.print(value);
        }
    }
}
