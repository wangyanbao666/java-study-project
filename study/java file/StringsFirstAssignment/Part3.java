package StringsFirstAssignment;


/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurences(String s1, String s2){
        int i = s2.indexOf(s1);
        if (i==-1){
            return false;
        }else{
            String sub_s2 = s2.substring(i+1,s2.length());
            int i2 = sub_s2.indexOf(s1);
            if (i2==-1){
                return false;
            }else{
                return true;
            }
        }
    }
    public void testing(){
        String s1 = "a";
        String s2 = "banana";
        System.out.println(twoOccurences(s1,s2));
        String s3 = "an";
        String s4 = "banana";
        System.out.println(lastPart(s3,s4));        
        
    }
    public String lastPart(String s1, String s2){
        int i = s2.indexOf(s1);
        if (i==-1){
            return s2;
        }else{
            String sub = s2.substring(i+s1.length(),s2.length());
            return sub;
        }
    }
}
