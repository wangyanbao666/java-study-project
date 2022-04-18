package com.example.test1;

public class TestOuter {
    public static void main(String[] args){
//Instantiate OuterClass
        OuterClass outerClass = new OuterClass();
//Instantiate the InnerClass
        OuterClass.InnerClass innerClass = outerClass.new
                InnerClass();
//Show that InnerClass can access variables in OuterClass
//Show that InnerClass stores a reference to OuterClass
    }
}

