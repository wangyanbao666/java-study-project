package com.example.wk4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pset {
    public static boolean isAllCharacterUnique(String sIn) {
        //todo: add your implementation
        List<Integer> ascii = new ArrayList<>();
        for (int i = 0; i < sIn.length() ; i++) {
            int asciichar = sIn.charAt(i);
            ascii.add(asciichar);
        }
        Collections.sort(ascii);
        for (int i = 0; i < sIn.length() - 1; i++) {
            if (ascii.get(i).equals(ascii.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Pset p = new Pset();
        p.isAllCharacterUnique("abb");
    }
}
