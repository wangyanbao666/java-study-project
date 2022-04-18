package com.example.wk4;

import java.util.ArrayList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed



    Permutation(final String str){
        in = str;
        // additional initialization if needed

    }

    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        perm(in,"");

    }

    public void perm(String s1,String s2){
        if (s2.length()==in.length()){
            a.add(s2);
        }
        else{
            for (int i=0; i<s1.length();i++){
                String s_2 = s2+s1.charAt(i);
                String s_1 = "";
                if (i==0){
                    s_1 = s1.substring(1);
                }
                else {
                    s_1 = s1.substring(0, i) + s1.substring(i + 1);
                }
                perm(s_1,s_2);
                System.out.println(s_2);
            }
        }
    }

    public ArrayList<String> getA(){
        return a;
    }

    public static void main(String[] args) {
        ArrayList<String> v;
        Permutation p = new Permutation("tha");
        p.permute();
        v = p.getA();
        System.out.println(v);
    }
}

