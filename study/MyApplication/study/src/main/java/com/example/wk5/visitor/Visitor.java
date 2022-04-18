package com.example.wk5.visitor;


public interface Visitor {
    void visit(Book b);
    void visit(Cloth c);
    void visit(CD cd);
}
