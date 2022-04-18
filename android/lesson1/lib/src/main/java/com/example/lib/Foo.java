package com.example.lib;

public class Foo {
    interface Bar {
        void drink();
    }

    public void thirsty(Bar bar){
        bar.drink();
    }
}
