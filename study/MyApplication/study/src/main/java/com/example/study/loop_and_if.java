package com.example.study;

public class loop_and_if {
    public static void main(String[] args) {
        int age = 19;
        String age_group = "";
        if (age<10) {
            age_group = "child";
        }else if (age<20) {
            age_group = "teen";
        }else {
            age_group = "old";
        }
        System.out.println("you are "+age_group);

//        for loop
        for (int i=0; i<=4; i++) {
            System.out.println(i);
        }
    }
}
