package Strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs)); // O(m.nlogn) where m is the length of the string array and nlogn is for sorting
        System.out.println(groupAnagrams1(strs)); // O(m.n)
        System.out.println(groupAnagrams2(strs)); // This will not work because arrays doesn't override equals() and hashcode() methods in java and map.containsKey() requires it
    }

    private static List<List<String>> groupAnagrams2(String[] strs) {
        Map<int[], List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            char[] chars = str.toCharArray();
            for(char c: chars) {
                count[c - 'a']++;
            }
            if(!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            char[] chars = str.toCharArray();
            for(char c: chars) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
