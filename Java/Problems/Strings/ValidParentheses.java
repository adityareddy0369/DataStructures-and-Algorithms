package Strings;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(validParentheses(s)); // O(n)
        System.out.println(validParentheses1(s)); // O(n^2) Without stack
        System.out.println(validParentheses2(s)); // O(n)
    }

    private static boolean validParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                switch (c) {
                    case ')':
                        if(stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if(stack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if(stack.pop() != '[') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean validParentheses1(String s) {
        while(true) {
            if(s.contains("()")) {
                s = s.replace("()", "");
            } else if(s.contains("{}")) {
                s = s.replace("{}", "");
            } else if(s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                return s.isEmpty();
            }
        }
    }

    private static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
