package com.example.wk5;

public class Student implements Observer1{
    private String id;
    private String msg;
    private Subject1 subject1;

    Student(String id, Subject1 subject){
        this.id = id;
        this.subject1 = subject;
        this.subject1.register(this);
    }

    @Override
    public void update(String msg){
        this.msg = msg;
        System.out.println(this.id+" receives: "+msg);
    }
}
