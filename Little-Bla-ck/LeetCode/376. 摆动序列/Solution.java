import java.util.Arrays;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return 1;
        }
        int dp[][] = new int[len][2];
        
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
            dp[i][1] = 0;
        }
        //dp第二列，0表示未初始化，即子串的第一位，大于小于均可；
        //1表示子串上一位大于这一位；
        //-1表示子串上一位小于这一位；
        int max = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] == 0) {
                    continue;
                    //防止数组中出现重复项，直接跳过，升降子串长度不变；
                }

                if ((nums[i] - nums[j]) * dp[j][1] >= 0) 
                //等于0表示上一位是升降串的第一位，大于小于均可；
                //大于0表示同号，可理解为由i项到j项满足升降串要求；
                {
                    
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    //找到第i项之前的里面最大的并加1；
                    dp[i][1] = -(Math.abs((nums[i] - nums[j])) / ((nums[i] - nums[j])));
                    //取符号并变号，存入表示大于小于号的dp第二列；
                    max = Math.max(max, dp[i][0]);
                    //保存最大值；
                }
            }
        }
        return max;
    }

    public int bestWiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3,3,5,2};
        System.out.println(solution.wiggleMaxLength(nums));
    }
}