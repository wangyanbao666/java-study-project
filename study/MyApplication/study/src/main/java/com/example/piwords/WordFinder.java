package com.example.piwords;

import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    /**
     * Given a String (the haystack) and an array of Strings (the needles),
     * return a Map<String, Integer>, where keys in the map correspond to
     * elements of needles that were found as substrings of haystack, and the
     * value for each key is the lowest index of haystack at which that needle
     * was found. A needle that was not found in the haystack should not be
     * returned in the output map.
     * 
     * @param haystack The string to search into.
     * @param needles The array of strings to search for. This array is not
     *                mutated.
     * @return The list of needles that were found in the haystack.
     */
    public static Map<String, Integer> getSubstrings(String haystack,
                                                     String[] needles) { 
        // TODO: Implement (Problem e)
        HashMap hm= new HashMap<String, Integer>();
        for (String s:needles){
            Integer startIndex = haystack.indexOf(s);
            if (startIndex!=1){
                hm.put(s,startIndex) ;
            }
        }
        return hm;
    }

    public static void main(String[] args) {
        String[] sa = {"I","am","a","k"};
        Map a = getSubstrings("I am a boy",sa);
        System.out.println(a);
    }
}
