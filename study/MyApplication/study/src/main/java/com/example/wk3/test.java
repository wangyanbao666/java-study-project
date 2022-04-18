package com.example.wk3;

public class test {
    public static boolean equalArea(GeoObject o1, GeoObject o2){
        return o1.getArea()== o2.getArea();
    }

    public static void main(String[] args) {
        Circle circle = new Circle(4,"ye");
//        declared type
//        actual type
//        System.out.println((new Circle()).getClass());
        Object o = new Circle();
        GeoObject c2 = new GeoObject() {
            @Override
            public double getArea() {
                return 0;
            }
        };  //up casting

//        Circle c = (Circle) c2;     //down casting if c2 is not Circle (e.g. rect) will cast error


        String color = circle.getColor();
//        System.out.println(color);
        System.out.println(circle);
        System.out.println(equalArea(circle,circle));
        class A{
            public void print(){
                System.out.println("public A");
            }
        }
        A a = new A();
        a.print();
    }

}
