package Strings;

public class Uncompress {
    public static void main(String[] args) {
        String s = "2t3o11g2s";
        System.out.println(uncompress(s));
    }

    // n: number of groups(2t, 30..), m: max number in a group(11)
    // time: O(nm), space: O(nm)
    private static String uncompress(String s) {
        String numbers = "0123456789";
        int i = 0;
        int j = 0;
        String result = "";
        while(j < s.length()) {
            String character = String.valueOf(s.charAt(j)); // string contains method only takes string or char sequence but not chat
            if(numbers.contains(character)) {
                j++;
            } else {
                int number = Integer.parseInt(s.substring(i, j));
                result += character.repeat(number);
                j++;
                i = j;
            }
        }
        return result;
    }
}
