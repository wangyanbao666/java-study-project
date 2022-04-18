package com.example.wk4;

public class exception {
    public static int myCompute(int i,int j){
        try{
            int r = i/j;
            return r;
        }
        // extends from Exception
        catch (ArithmeticException ex){
            return 0;
        }
    }
    public static void main(String[] args) {
        int result = myCompute(1,0);
        System.out.println(result);
    }

}
