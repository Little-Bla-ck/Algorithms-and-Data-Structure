public class CheckPartitioning {
    public boolean checkPartitioning(String partition) {
        int length = partition.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (partition.charAt(i) != partition.charAt(j)) {
                    continue;
                }
                dp[i][j] = j - i <= 2 || dp[i - 1][j + 1];
            }
        }
        //计算出该字符串的所有子串是否为回文字符串，并储存；
        //双指针将字符串分为三段，并判断三段是否同时为回文字符串；
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][length - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckPartitioning checkPartitioning = new CheckPartitioning();
        System.out.println(checkPartitioning.checkPartitioning("abcbdd"));
    }
}
