package DP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 4;
        System.out.println(countingChange(coins,0, amount, new HashMap<>()));
    }
    private static int countingChange(int[] coins, int coinIndex, int amount, Map<List<Integer>, Integer> memo) {
        if(amount == 0) {
            return 1;
        }
        if(coinIndex >= coins.length) {
            return 0;
        }
        List<Integer> key = List.of(amount, coinIndex);
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int totalWays = 0;
        for(int i = 0; i*coins[coinIndex] <= amount; i++) {
            int subAmount = amount-(coins[coinIndex]*i);
            totalWays += countingChange(coins, coinIndex+1, subAmount, memo);
        }
        memo.put(key, totalWays);
        return totalWays;
    }


}
