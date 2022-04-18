package com.example.wk5;

public class MyClass {
    public static void main(String[] args) {
        Topic t = new Topic();
        Student s = new Student("wyb",t);
        t.postMsg("class over");
    }
}
