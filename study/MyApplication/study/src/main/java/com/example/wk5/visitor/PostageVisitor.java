package com.example.wk5.visitor;

public class PostageVisitor implements Visitor{
    public double total=0;
    @Override
    public void visit(Book book){
        total+=10*book.getPrice();
    }

    @Override
    public void visit(CD cd) {
        if (cd.getTitle()=="EX"){
            total+=10;
        }
        else{
            total+=5;
        }
    }

    @Override
    public void visit(Cloth c) {
        total+=c.getSize()*20;
    }

    public void setTotal(double d){total=d;}
}
