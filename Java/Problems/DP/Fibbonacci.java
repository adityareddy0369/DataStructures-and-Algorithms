package DP;

import java.util.HashMap;
import java.util.Map;
// freeCodeCamp.org: Dynamic Programming with Java – Learn to Solve Algorithmic Problems & Coding Challenges
// 0 1 2 3 4 5 6 7
// 0 1 1 2 3 5 8 13
public class Fibbonacci {
    public static void main(String[] args) {
        System.out.println(fibOf(7, new HashMap<>()));
    }

    private static int fibOf(int n, Map<Integer, Integer> memo) {
        if(n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int sum =  fibOf(n-1, memo) + fibOf(n-2, memo);
        memo.put(n, sum);
        return sum;
    }
}
