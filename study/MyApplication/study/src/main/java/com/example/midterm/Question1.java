package com.example.midterm;

import java.util.ArrayList;

public class Question1 {

    public static void main(String[] args) {

        //output: 25
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sumThreeAndSeven(values));

        // output: shnydys
        System.out.println( dropVowelsAndCase("SHINYuDays")); //shnydys

        // output: [3, 0, 2, 2, 4, 6, 10]
        System.out.println(someSequence(6));
        // output: [3, 0, 2, 2]
        System.out.println(someSequence(10));
    }

    public static int sumThreeAndSeven( int[] values){
        int result=0;
        for (int i:values){
            if (i%3==0 || i%7==0){
                result = result+i;
            }
        }
        return result;
    }

    public static String dropVowelsAndCase(String s){
        String s_lower = s.toLowerCase();
        String result = "";
        for (int i=0; i<s_lower.length();i++){
            if (!(s_lower.charAt(i)=='a')&&!(s_lower.charAt(i)=='e')&&!(s_lower.charAt(i)=='i')&&!(s_lower.charAt(i)=='o')&&!(s_lower.charAt(i)=='u')){
                result = result+s_lower.charAt(i);
            }
        }
        return result;
    }

    public static ArrayList<Integer> someSequence(int n){
        ArrayList<Integer> al = new ArrayList<>();
        if (n>=0){ al.add(3);}
        if (n>=1){al.add(0);}
        if (n>=2){al.add(2);}
        if (n>=3){
            for (int i=3; i<=n;i++){
                al.add(al.get(i-1)+al.get(i-2));
            }
        }
        return al;
    }


}