package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// constraints: always guarantee to have a single 2 pair that returns the target
public class TwoSumPairs {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 1};
        int target = 8;
        System.out.println(Arrays.toString(twoSumPairsBruteForce(arr, target)));
        System.out.println(Arrays.toString(twoSumPairs(arr, target)));
    }

    private static int[] twoSumPairs(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sub = target - arr[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    private static int[] twoSumPairsBruteForce(int[] arr, int target) {
        for(int i = 0; i< arr.length; i++) {
            for(int j = i+1; j< arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
