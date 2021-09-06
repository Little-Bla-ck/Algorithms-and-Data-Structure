public class MinDistance {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 * length2 == 0) {
            return length1 + length2; 
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < length2; i++) {
            dp[0][i] = i;
        }
        //边界条件判断完毕，相当于全部添加；
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (word1.charAt(i) == words.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[length1][length2];
    }
}