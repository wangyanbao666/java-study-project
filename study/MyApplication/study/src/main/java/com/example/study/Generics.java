package com.example.study;

import java.util.LinkedList;

public class Generics {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList<String> ll2 = new LinkedList<String>();
        ll.add(1);
        ll.add("kk");
//        ll2.add(1);
        ll2.add("kk");
//        ll2.add('k');
    }
}
