package DP;

import java.util.HashMap;
import java.util.Map;

public class SumPossible {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int amount = 4;
        System.out.println(sumPossible(numbers, amount, new HashMap<>()));
    }

    private static boolean sumPossible(int[] numbers, int amount, Map<Integer, Boolean> memo) {
        if(amount == 0) {
            return true;
        }
        if(amount < 0) {
            return false;
        }
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }
        for(int i = 0; i< numbers.length; i++) {
            if(sumPossible(numbers, amount-numbers[i], memo)) {
                memo.put(amount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }
}
