package com.example.Test;

import com.example.wk3.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        Circle[] al = new Circle[5];
        al[0]=new Circle(1);
        al[1]=new Circle(2);
        al[2]=new Circle(3);
        Circle x = al[1];
        al[1]=new Circle(10);
        System.out.println(x);
//        System.out.println("abc"<"abd");
    }
}
