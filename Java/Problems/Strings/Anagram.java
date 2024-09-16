package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "restful";
        String t = "fluster";
        System.out.print(isAnagram(s, t));
        System.out.println();
        System.out.print(isAnagram1(s, t));
        System.out.println();
        System.out.print(isAnagram2(s, t)); // O(nlogn) coz of sorting
        System.out.println();
        System.out.print(isAnagram3(s, t));
        System.out.println();
        System.out.print(isAnagram4(s, t));
        System.out.println();
        System.out.print(isAnagram5(s, t));
    }

    private static boolean isAnagram5(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i< s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int val: count) {
            if(val != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram4(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }
        for(int value: map.values()) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char sChar: s.toCharArray()) {
            map.put(sChar, map.getOrDefault(sChar, 0)+1);
        }
        for(char tChar: t.toCharArray()) {
            map.put(tChar, map.getOrDefault(tChar, 0)-1);
        }
        for(int value: map.values()) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    private static boolean isAnagram1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = charCount(s1);
        Map<Character, Integer> map2 = charCount(s2);
        for(char key: map1.keySet()) {
            if(!map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
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
