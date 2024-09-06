package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLength {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubStringLength(s)); // O(n^3)
        System.out.println(longestSubStringLength1(s)); // O(n^2)
        System.out.println(longestSubStringLength2(s)); // O(n)
    }

    private static int longestSubStringLength2(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right< s.length(); right++) {
            char currentChar = s.charAt(right);
            while(set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    private static int longestSubStringLength1(String s) {
        int maxLength = 0;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for(int right = 0; right< s.length(); right++) {
            char currentChar = s.charAt(right);
            int index = sb.indexOf(String.valueOf(currentChar));
            if(index != -1) {
                sb.delete(0, index+1);
            }
            sb.append(currentChar);
            maxLength = Math.max(maxLength, sb.length());
        }
        return maxLength;
    }

    private static int longestSubStringLength(String s) {
        int maxLength = 0;
        for(int i = 0; i< s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j< s.length(); j++) {
                if(sb.indexOf(String.valueOf(s.charAt(j))) != -1) { // indexOf method uses O(n) time
                    break;
                }
                sb.append(s.charAt(j));
                maxLength = Math.max(maxLength, sb.length());
            }
        }
        return maxLength;
    }
}
