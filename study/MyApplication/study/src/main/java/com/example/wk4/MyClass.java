package com.example.wk4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyClass {
    public static void main(String[] args) {
        Eatable duck = new Duck();
        System.out.println(duck.Eat());

        ArrayList<Eatable> l = new ArrayList<Eatable>();
        l.add(duck);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(-1);
        l2.add(-4);
        l2.add(3);
        l2.add(2);
        IntegerAbsComparator comparator = new IntegerAbsComparator();
        Collections.sort(l2,comparator);
        System.out.println(l2);
    }
}
