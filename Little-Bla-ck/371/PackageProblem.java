public class PackageProblem {
    public int packageProblem(int[] weights, int[] values, int maxWeight) {
        int[][] dp = new int[weights.length + 1][maxWeight + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][maxWeight];
    }

    public static void main(String[] args) {
        PackageProblem p = new PackageProblem();
        int packageContainWeight = 4;//包最大可装重量
        int[] weight = {1, 4, 3};//3个物品的重量
        int[] value = {150, 300, 200};//3个物品的价值
        System.out.println(p.packageProblem(weight, value, packageContainWeight));
    }
}
