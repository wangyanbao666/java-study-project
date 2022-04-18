package com.example.wk5.visitor;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<Visitable> a = new ArrayList<>();
        PostageVisitor v = new PostageVisitor();
        a.add(new Book(10));
        a.add(new CD("EX"));
        a.add(new CD("kk"));
        a.add(new Cloth(20));

        for (Visitable va:a){
            va.accept(v);
        }
        v.setTotal(0);

    }
}
