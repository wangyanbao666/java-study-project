package com.example.wk4;

public interface Eatable {
    public abstract String Eat();
    public static final int K=1;
}

class Animal {

}

class Chicken extends Animal implements Eatable{
    @Override
    public String Eat(){
        return "boil";
    }
}

class Duck extends Animal implements Eatable{
    @Override
    public String Eat(){
        return "steam";
    }
}

class Chocolate implements Eatable{
    @Override
    public String Eat() {
        return "";
    }
}