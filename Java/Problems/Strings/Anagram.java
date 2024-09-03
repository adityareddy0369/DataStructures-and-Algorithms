package Strings;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "restful";
        String s2 = "fluster";
        System.out.print(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = charCount(s1);
        Map<Character, Integer> map2 = charCount(s2);
        if(map1.equals(map2)) {
            return true;
        } else {
            return false;
        }
    }

    private static Map<Character, Integer> charCount(String s1) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s1.length(); i++) {
            if(map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i),  map.get(s1.charAt(i))+1);
            }else {
                map.put(s1.charAt(i), 1);
            }
        }
        return map;
    }
}
