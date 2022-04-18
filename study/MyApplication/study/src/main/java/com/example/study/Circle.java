package com.example.study;

public class Circle implements Comparable<Circle>{
    static int numOfCircle = 0;
    double radius;
    double getArea(){
        return Math.pow(radius,2)*Math.PI;
    }
//    no-arg constructor
    Circle(){
        radius = 1.0;
        numOfCircle++;
    }
    Circle(double r){
        radius = r;
        numOfCircle++;
    }
    @Override
    public int compareTo(Circle c){
        if (this.radius>c.radius){
            return 1;
        }
        else if (this.radius==c.radius){
            return 0;
        }
        else {
            return -1;
        }
    }

    public String toString(){
        return "radius: "+this.radius;
    }

}
