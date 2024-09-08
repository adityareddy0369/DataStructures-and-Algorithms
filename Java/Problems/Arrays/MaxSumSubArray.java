package Arrays;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubSumArray(nums));  // O(n^3)
        System.out.println(maxSubSumArray1(nums)); // O(n^2)
        System.out.println(maxSubSumArray2(nums)); // O(n)
    }

    private static int maxSubSumArray2(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = 0;
        for(int i = 0; i< n; i++) {
           sum += nums[i];
           maxSum = Math.max(maxSum, sum);
           if(sum < 0) {
               sum = 0;
           }
        }
        return maxSum;
    }

    private static int maxSubSumArray1(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i< n; i++) {
            int currSum = 0;
            for(int j = i; j< n; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    private static int maxSubSumArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i< n; i++) {
            for(int j = i; j< n; j++) {
                int currSUm = 0;
                int k = i;
                while (k<= j) {
                    currSUm += nums[k];
                    k++;
                }
                maxSum = Math.max(maxSum, currSUm);
            }
        }
        return maxSum;
    }
}
