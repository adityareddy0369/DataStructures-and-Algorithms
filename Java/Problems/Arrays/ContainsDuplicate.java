package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate3(nums)); // O(n^2): time limit exceeds
    }

    private static boolean containsDuplicate3(int[] nums) {
        for(int i = 0; i< nums.length; i++) {
            for(int j = i+1; j< nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    private static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
