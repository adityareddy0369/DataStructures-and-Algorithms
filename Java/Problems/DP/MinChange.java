package DP;

import java.util.HashMap;
import java.util.Map;

public class MinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        System.out.println(minChange(coins, amount, new HashMap<>()));
    }

    private static int minChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if(memo.containsKey(amount)) {
            memo.get(amount);
        }
        int minCoins = -1;
        for(int coin: coins) {
            int subCoins = minChange(coins, amount-coin, memo);
            if(subCoins != -1) {
                int numCoins = subCoins+1;
                if(numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }
        memo.put(amount, minCoins);
        return minCoins;
    }
}
