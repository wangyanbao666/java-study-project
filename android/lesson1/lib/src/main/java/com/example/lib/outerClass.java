package com.example.lib;

public class outerClass {
    int a;
    outerClass (){a=10;}
    void printA(){
        System.out.println(a);
    }
    class innerClass {
        int c;
        void innerPrint(){
            System.out.println(a);
        }
    }
}
