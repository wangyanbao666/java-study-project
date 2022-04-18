package com.example.norman_lee.myapplication;

public class Utils {
    public static void checkInvalidInputs (String value){
        if (value.equals("")){
            throw new NumberFormatException();
        }
        if (Double.valueOf(value)<=0){
            throw new IllegalArgumentException();
        }
    }
}
