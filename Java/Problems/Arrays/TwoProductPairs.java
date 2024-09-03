package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoProductPairs {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 2, 5, 1};
        int target = 9;
        System.out.println(Arrays.toString(twoProductPairsWithDouble(arr, target)));
        System.out.println(Arrays.toString(twoProductPairs(arr, target)));
    }

    private static int[] twoProductPairs(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            if(target%arr[i] == 0) {
                int div = target / arr[i];
                if (map.containsKey(div)) {
                    return new int[]{map.get(div), i};
                }
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    private static int[] twoProductPairsWithDouble(int[] arr, int target) {
        Map<Double, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            double div = (double)target/arr[i];
            if(map.containsKey(div)) {
                return new int[]{map.get(div), i};
            }
            map.put((double)arr[i], i);
        }
        return new int[]{};
    }
}
