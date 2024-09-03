package Strings;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentChar {
    public static void main(String[] args) {
        String s = "mississippi";
        System.out.println(mostFrequentChar(s));
    }

    private static char mostFrequentChar(String s) {
        Map<Character, Integer> map = charCount(s);
        char result = s.charAt(0);
        for(int i = 1; i< s.length(); i++) {
            if(map.get(s.charAt(i)) > map.get(result)) {
                result = s.charAt(i);
            }
        }
        return result;
    }

    private static Map<Character, Integer> charCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            /*if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);*/
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return map;
    }
}
