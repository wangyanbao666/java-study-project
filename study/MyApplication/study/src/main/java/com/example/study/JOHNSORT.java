package com.example.study;

public class JOHNSORT {
    public static int[] sort(int[] arr){
        int t = 0;
        for (int i=arr.length-1; i>=0; i--){
            for (int j=arr.length-1; j>=1; j--){
                if (arr[j]>arr[j-1]){
                        t = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1]=t;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = sort(new int[]{20,3,34,5,7,6,9,8,10,11,12,14,13,19,17,13});
        for (int i:arr){
            System.out.println(i);
        }
    }
}
