package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingReplacementSubStringLength {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(longestRepeatingReplacementSubStringLength(s, k)); // O(26n)
        System.out.println(longestRepeatingReplacementSubStringLength1(s, k)); // O(n)
        System.out.println(longestRepeatingReplacementSubStringLength2(s, k)); // O(n) faster than using hashmap
    }

    private static int longestRepeatingReplacementSubStringLength2(String s, int k) {
        int[] chars = new int[26];
        int maxLength = 0;
        int maxFrequency = 0;
        int l = 0;
        for(int r = 0; r< s.length(); r++) {
            char currentChar = s.charAt(r);
            int windowLength = r-l+1;
            chars[currentChar - 'A']++; // char A  = 65
            maxFrequency = Math.max(maxFrequency,  chars[currentChar - 'A']);
            if(windowLength - maxFrequency <= k) {
                maxLength = Math.max(maxLength, windowLength);
            } else {
                chars[s.charAt(l) - 'A']--;
                l++;
            }
        }
        return maxLength;
    }

    private static int longestRepeatingReplacementSubStringLength1(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int maxFrequency = 0;
        int l = 0;
        for(int r = 0; r< s.length(); r++) {
            int windowLength = r-l+1;
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0)+1);
            maxFrequency = Math.max(maxFrequency, map.get(currentChar));
            if(windowLength - maxFrequency <= k) {
                maxLength = Math.max(maxLength, windowLength);
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
        }
        return maxLength;
    }

    private static int longestRepeatingReplacementSubStringLength(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int l = 0;
        for(int r = 0; r< s.length(); r++) {
            int windowLength = r-l+1;
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0)+1);
            int maxFrequency = 0;
            for(int value: map.values()) {
                maxFrequency = Math.max(maxFrequency, value);
            }
            if(windowLength - maxFrequency <= k) {
                maxLength = Math.max(maxLength, windowLength);
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
        }
        return maxLength;
    }
}
