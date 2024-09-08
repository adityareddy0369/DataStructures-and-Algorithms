package Arrays;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productOfArray(nums))); // O(n^2): Time Limit Exceeded
        System.out.println(Arrays.toString(productOfArray1(nums))); // Using division but will not work for zero values
        System.out.println(Arrays.toString(productOfArray2(new int[]{1,2,3,4}))); // time and space: O(n)
        System.out.println(Arrays.toString(productOfArray3(new int[]{1,2,3,4}))); // time: O(n), space: O(1)
        System.out.println(Arrays.toString(productOfArray4(new int[]{1,2,3,4}))); // using division by tracking number of zeros. faster and less space according to leetcode
    }

    private static int[] productOfArray4(int[] nums) {
        int n = nums.length;
        int product = 1;
        int zeroCount = 0;
        int[] result = new int[n];
        for(int num: nums) {
            if(num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        if(zeroCount > 1) {
            return result;
        }
        if(zeroCount == 1) {
            for(int i = 0; i< n; i++) {
                if(nums[i] == 0) {
                    result[i] = product;
                }
            }
            return result;
        }

        for(int j = 0; j< n; j++) {
            result[j] = product/nums[j];
        }
        return result;
    }

    // Even tho we use a new result array to store the result the space complexity is still O(1), since we are not using that result array for any computation.
    private static int[] productOfArray3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prefix = 1;
        for(int i = 0; i< n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for(int j = n-1; j>= 0; j--) {
            result[j] *= suffix;
            suffix *= nums[j];
        }
        return result;
    }

    private static int[] productOfArray2(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i = 1; i< n; i++) {
            prefix[i] = prefix[i-1]*nums[i];
        }
        for(int j = n-2; j>= 0; j--) {
            suffix[j] = suffix[j+1]*nums[j];
        }
        nums[0] = suffix[1];
        nums[n-1] = prefix[n-2];
        for(int k = 1; k< n-1; k++) {
            nums[k] = prefix[k-1]*suffix[k+1];
        }
        return nums;
    }

    private static int[] productOfArray1(int[] nums) {
        int product = 1;
        for(int num: nums) {
            product *= num;
        }
        for(int i = 0; i< nums.length; i++) {
            nums[i] = product/nums[i];
        }
        return nums;
    }

    private static int[] productOfArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            int product = 1;
            for(int j = 0; j< nums.length; j++) {
                if(i != j) {
                    product = product*nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}
