public class MaxSubArray {
    public int maxSubArray(int[] num) {
        int length = num.length;
        int[] dp = new int[length];
        int max = num[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + num[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubArray max = new MaxSubArray();
        int[] nums = {0};
        max.maxSubArray(nums);
    }
}