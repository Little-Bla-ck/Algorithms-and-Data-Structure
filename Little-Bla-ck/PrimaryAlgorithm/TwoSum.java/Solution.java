import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> Nums = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (Nums.get(target - nums[i]) != null) {
                return new int[]{Nums.get(target - nums[i]), i};
            }
            Nums.put(nums[i], i);
        }

        return new int[]{0 ,0};
    }
}
