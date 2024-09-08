package Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProductSubArray(nums)); // O(n^3)
        System.out.println(maxProductSubArray1(nums)); // O(n^2)
        System.out.println(maxProductSubArray2(nums)); // O(n)
    }

    private static int maxProductSubArray2(int[] nums) {
        return 0;
    }

    private static int maxProductSubArray1(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        for(int i = 0; i< n; i++) {
            int product = 1;
            for(int j = i; j< n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    private static int maxProductSubArray(int[] nums) {
        int n = nums.length;
        int maxProdcut = nums[0];
        for(int i = 0; i< n; i++) {
            for(int j = i; j< n; j++) {
                int product = 1;
                int k = i;
                while(k<=j) {
                    product *= nums[k];
                    k++;
                }
                maxProdcut = Math.max(maxProdcut, product);
            }
        }
        return maxProdcut;
    }
}
