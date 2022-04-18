package com.example.wk4;

import java.util.Comparator;

public class IntegerAbsComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        if (Math.abs(a)>Math.abs(b)){
            return 1;
        }
        else if (Math.abs(a)==Math.abs(b)){
            return 0;
        }
        else {
            return -1;
        }
    }
}
