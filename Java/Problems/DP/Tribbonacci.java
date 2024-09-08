package DP;

import java.util.HashMap;
import java.util.Map;

// 0 1 2 3 4 5 6 7
// 0 1 1 2 3 5 8 13
public class Tribbonacci {
    public static void main(String[] args) {
        System.out.println(tribOf(7, new HashMap<>()));
    }

    private static int tribOf(int n, Map<Integer, Integer> memo) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(n == 2) {
            return 1;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        int sum = tribOf(n-1, memo) + tribOf(n-2, memo) + tribOf(n-3, memo);
        memo.put(n, sum);
        return sum;
    }
}
