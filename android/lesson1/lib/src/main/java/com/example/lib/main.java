package com.example.lib;

public class main {
    public static void main(String[] args) {
//        MyClass a = new MyClass();
//        MyClass b = new MyClass();
//        a.i=100;
//        System.out.println(b.j);
//        MyClass c = new MyClass();
//        System.out.println(c.j);
//        System.out.println();
        outerClass o = new outerClass();
        o.printA();
        outerClass.innerClass i = new outerClass().new innerClass();
    }
}
