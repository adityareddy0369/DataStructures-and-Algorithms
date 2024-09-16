package Strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(s));
        System.out.println(validPalindrome1(s));
    }

    private static boolean validPalindrome1(String s) {
        if(s.isEmpty()) return true;
        int start = 0;
        int end = s.length()-1;
        while(start<= end) {
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);
            if(!Character.isLetterOrDigit(charStart)) {
                start++;
            } else if(!Character.isLetterOrDigit(charEnd)) {
                end--;
            } else {
                if((Character.toLowerCase(charStart) != Character.toLowerCase(charEnd))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    private static boolean validPalindrome(String s) {
        if(s.isEmpty()) return true;
        String filteredStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = filteredStr.length()-1;
        while(start <= end) {
            if(filteredStr.charAt(start) != filteredStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
