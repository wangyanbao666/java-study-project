package com.example.wk4;

public class C1 implements i1{
    public void p1(){
        System.out.println("p1");
    }
    public void p11(){
        System.out.println("p11");
    }
    public void p12(){
        System.out.println("p12");
    }
    public static void main(String[] args) {
        new C1().p1();
    }
}

class C2 extends C1{

}

interface i11{
    void p11();
}

interface i12{
    void p12();
}

interface i1 extends i12,i11{
    void p1();
}