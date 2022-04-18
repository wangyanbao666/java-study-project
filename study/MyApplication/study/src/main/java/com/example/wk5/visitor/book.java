package com.example.wk5.visitor;


class Book implements Visitable{
    private int price;
    public int getPrice() {
        return price;
    }
    public Book(int price){
        this.price=price;
    }
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}

class CD implements Visitable{
    public String getTitle() {
        return title;
    }
    private String title;
    public CD(String title){
        this.title = title;
    }
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}

class Cloth implements Visitable{
    private int size;
    public Cloth(int s){
        this.size=s;
    }
    public int getSize() {
        return size;
    }
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}

