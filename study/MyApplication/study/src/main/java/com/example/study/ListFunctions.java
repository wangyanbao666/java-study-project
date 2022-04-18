package com.example.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListFunctions {
    public static void main(String[] args) {
        Integer[] a = new Integer[50000];
        System.out.println(a[0]);
        List<Integer> w = new LinkedList<>(Arrays.asList(a));
        int totalCount = 100000;
        long start = System.nanoTime();
        for (int i=0; i<totalCount; i++) {
            w.get(25000);
        }
        long end = System.nanoTime();
        long duration = end-start;
        System.out.println("total time is: "+duration/1000000.0+" ms");
    }
}
