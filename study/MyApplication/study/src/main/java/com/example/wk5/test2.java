package com.example.wk5;

public class test2 {
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {
        // TODO: Implement (Problem f)
        if(base < 0){
            return null;
        }

        String validChar = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        double[] prob = new double[26];
        char[] alphabet = validChar.toCharArray();
        int sum = 0;
        char[] result = new char[base];

        // pretreated
        for (String i:trainingData){
            i = i.toLowerCase();
        }

        // count
        for (int i=0; i<trainingData.length; i++){
            for (int k=0; k<trainingData[i].length(); k++){
                if (validChar.indexOf(trainingData[i].charAt(k)) != -1){
                    count[validChar.indexOf(trainingData[i].charAt(k))] += 1;
                    sum += 1;
                }
            }
        }

//        // bubble sort ascending order
//        for (int i=0; i<count.length-1;i++){
//            for (int j=0; j<count.length-1-i;j++){
//                if (count[j]>count[j+1]){
//                    int temp_c = count[j];
//                    char temp_a = alphabet[j];
//                    count[j] = count[j+1];
//                    alphabet[j] = alphabet[j+1];
//                    count[j+1] = temp_c;
//                    alphabet[j+1] = temp_a;
//                }
//            }
//        }

        for (int i=0; i<count.length; i++){
            int cdf = 0;
            double d_cdf;
            for (int j=0; j<=i; j++){
                cdf += count[j];
            }
            d_cdf = cdf / (sum*1.0);
            prob[i] = d_cdf*base;
        }

        int j = 0;
        for (int i=0; i<base; i++){
            while (prob[j]<=i){
                j += 1;
            }
            result[i] = alphabet[j];
        }
        return result;
    }
    public static void main(String[] args) {
        test t = new test();
        char[] o = t.generateFrequencyAlphabet(13,new String[]{"A_(*gj","]","[","=","-","v","g","0","kk"});
        System.out.println(o);
    }

}

