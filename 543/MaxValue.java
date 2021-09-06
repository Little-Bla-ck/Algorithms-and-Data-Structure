public class MaxValue{
    public int maxValue(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[length + 1][width + 1];
        //dp[i][j]代表从(0, 0)走到(i, j)能拿到的最大价值；
        //将二维数组建大一位减少边界判断；
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        //从右下往左上遍历；
        return dp[length][width];
    }

    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        int[][] grid = 
        {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1},
        };
        System.out.println(maxValue.maxValue(grid));
    }
}