package Arrays;

public class BestTimeBuyStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bestTimeBuyStock(prices)); //  time limit exceeds
        System.out.println(bestTimeBuyStock1(prices)); // sliding window
    }

    private static int bestTimeBuyStock1(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }

    private static int bestTimeBuyStock(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i< prices.length; i++) {
            for(int j = i+1; j< prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        if(maxProfit <= 0) {
            return 0;
        } else {
            return maxProfit;
        }
    }
}
