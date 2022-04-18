package com.example.study;

import java.util.ArrayList;
import java.util.LinkedList;

public class array_list {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Object> ll = new LinkedList<>();
//        al.add(10);
//        al.add(20);
//        al.get(1);
//        al.get(0);
//        al.set(1,20);
//        al.remove(0);
//        System.out.println(al.get(0));
        ll.add(1);
        al.add(4,1);
        al.add(9);
        ll.add('k');

        Integer b = new Integer(11);
        Integer a = new Integer(10);

        System.out.println(b.compareTo(a));
        Circle c = new Circle(1);
    }
}
