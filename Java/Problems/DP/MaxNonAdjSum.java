package DP;

import java.util.HashMap;
import java.util.Map;

public class MaxNonAdjSum {
    public static void main(String[] args) {
        int[] nums = {2,4,5,12,7};
        System.out.print(maxNonAdjSum(nums));
    }

    private static int maxNonAdjSum(int[] nums) {
        return maxNonAdjSum(nums, 0, new HashMap<>());
    }

    private static int maxNonAdjSum(int[] nums, int i, Map<Integer, Integer> memo) {
        if(i >= nums.length) {
            return 0;
        }
        if(memo.containsKey(i)) {
            memo.get(i);
        }
        int sum =  Math.max((nums[i] + maxNonAdjSum(nums, i+2, memo)), maxNonAdjSum(nums, i+1, memo));
        memo.put(i, sum);
        return sum;
    }
}
