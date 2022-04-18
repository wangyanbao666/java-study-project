package com.example.wk3;

public abstract class GeoObject {
    private String color = "yellow";

    public GeoObject(String s) {
        color = s;
    }

    public GeoObject() {
        color = "yellow";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // abstract method
    public abstract double getArea();
}
