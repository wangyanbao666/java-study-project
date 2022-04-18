package com.example.wk5;

public class test {
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {

        if (base<0){
            return null;
        }
        char[]output=new char[base];
        int[]count=new int[26];
        int total=0;
        String correct="abcdefghijklmnopqrstuvwxyz";
        int before=0;
        double cdf;
        double[] bcdf=new double[26];

        for(String i:trainingData){
            i=i.toLowerCase();
            for(int j = 0; j<i.length(); j++){
                char k=i.charAt(j);
                int a=correct.indexOf(k);
                if(a!=-1){
                    count[a]+=1;
                    total+=1;
                }
            }
        }

        if(total<1){
            return output;
        }

        for(int i=0;i<count.length;i++){
            before=0;
            for(int j=0;j<=i;j++){
                before+=count[j];
            }
            cdf=before/(total*1.0);
            bcdf[i]=cdf*base;
        }

        int b=0;
        for (int i=0;i<base;i++){
            while(i>=bcdf[b]){
                b+=1;
            }
            output[i]=correct.charAt(b);
        }
        return output;
    }

    public static void main(String[] args) {
        test t = new test();
        char[] o = t.generateFrequencyAlphabet(13,new String[]{"A_(*gj","]","[","=","-","v","g","0","kk"});
        System.out.println(o);
    }
}
//aaggggjjkkkkv
//aaggggjjkkkkv
