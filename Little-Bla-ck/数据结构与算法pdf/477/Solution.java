public class Solution {
    //动态规划利用二维数组解；
    public int message1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][2];
        //0表示没接，1表示接了；
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[len][0], dp[len][1]);
    }

    //动态规划法内存优化;
    public int message2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        //0表示没接，1表示接了；
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(dp[0], dp[1]);
            dp[1] = dp[0] + nums[i];
            dp[0] = temp;
        }
        return Math.max(dp[0], dp[1]);
    }
}
