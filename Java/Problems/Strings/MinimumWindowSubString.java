package Strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubString(s, t));
    }

    private static String minimumWindowSubString(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int have = 0;
        int start = 0;
        for(char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }
        for(int r = 0; r< s.length(); r++) {
            char rightChar = s.charAt(r);
            if(tMap.containsKey(rightChar)) {
                sMap.put(rightChar, sMap.getOrDefault(rightChar,0)+1);
                if(sMap.get(rightChar).equals(tMap.get(rightChar))) {
                    have++;
                }
            }
            while (have == tMap.size()) {
                //minLength = Math.min(minLength, r-l+1);
                if(r-l+1 < minLength) {
                    minLength = r-l+1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                if(tMap.containsKey(leftChar)) {
                    sMap.put(leftChar, sMap.get(leftChar)-1);
                    if(sMap.get(leftChar) < tMap.get(leftChar)) {
                        have--;
                    }
                }
                l++;
            }
        }
        if(minLength < Integer.MAX_VALUE) {
           return  s.substring(start, start+minLength);
        } else {
            return "";
        }
    }
}
