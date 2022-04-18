package com.example.wk3;

public class Circle extends GeoObject{
    private double radius=1;
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Circle(){
        this(1.0,"green");
    }
    Circle(double r, String color){
        super(color);
        radius = r;
    }
    public Circle(double r){this.radius=r;}
    @Override
    public String toString(){
        return "the radius is: "+radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}
