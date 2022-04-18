package com.example.Test;

import com.example.wk4.Pset;

import java.util.Arrays;

public class Pset1 {
    public static boolean isAllCharacterUnique(String str) {
        //todo: add your implementation
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;

        // If no duplicate characters encountered,
        // return true
        return true;
    }
    public static Boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        s1 = new String(s1Arr);
        s2 = new String(s2Arr);
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        Pset1 p = new Pset1();
        System.out.println(p.isPermutation("acb{-ddesr[","abce-d{sdr["));
    }
}
