package com.example.lib;

public class TestFoo {
    public static void main(String[] argv){
        Foo f = new Foo();
        f.thirsty( new C() );
    }
    static class C implements Foo.Bar {
        @Override
        public void drink() {
            System.out.println("gulp");
        }
    }
}
