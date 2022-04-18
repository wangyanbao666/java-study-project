package com.example.study;

import java.util.ArrayList;
import java.util.Collections;

public class MyClasss {
    public static void main(String[] args) {
        Circle c = new Circle();
        Circle c2 = new Circle(2);
        Circle c3 = new Circle(3);
        ArrayList<Circle> l = new ArrayList<>();
        l.add(c2);
        l.add(c3);
        l.add(c);
        Collections.sort(l);
        System.out.println(l);
        System.out.println(Collections.max(l));
    }
}
