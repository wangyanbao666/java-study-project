package com.example.wk5;

import java.util.ArrayList;

public class Topic implements Subject1{
    private ArrayList<Observer1> a = null;
    private String msg;
    Topic(){
        a = new ArrayList<Observer1>();
    }
    @Override
    public void register(Observer1 o){
        a.add(o);
    }
    @Override
    public void unregister(Observer1 o){
        a.remove(o);
    }
    @Override
    public void notifyObserver(){
        for (Observer1 o:a){
            o.update(msg);
        }
    }
    public void postMsg(String msg){
        this.msg = msg;
        notifyObserver();
    }
}
