package com.example.study;

import java.util.ArrayList;
import java.util.Iterator;

public class test {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(4);

        Iterator<Integer> iter = a.iterator();
        iter.next();
        System.out.println(iter.next());

    }
}
