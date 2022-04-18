package com.example.study;

public class Method {
    public static void miao(){
        System.out.println("miao");
    }
    public static int add(int a, int b){
        return a+b;
    }
    public static void main(String[] args) {
        miao();
        int n = add(3,4);
        System.out.println(n);
    }
    Tree t = new Tree();
    public class Tree{

    }
}
