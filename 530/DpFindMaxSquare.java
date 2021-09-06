public class DpFindMaxSquare {
    public int dpFindMaxSquare(char[][] square) {
        int height = square.length;
        int width = square[0].length;
        int[][] dp = new int[height+1][width+1];
        int maxLine = -1;
        //从右下往左上搜索；
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (square[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    //它能够扩大的前提是它左边、左上角、上面的dp都要比它大1；
                }
                maxLine = Math.max(maxLine, dp[i][j]);
                //储存最长的边；
            }
        }

        return maxLine * maxLine;
    }

    public static void main(String[] args) {
        DpFindMaxSquare dp = new DpFindMaxSquare();
        char[][] square = new char[][]
        {
            {'1' , '0' , '1' , '0' , '0'},
            {'1' , '0' , '1' , '1' , '1'},
            {'1' , '1' , '1' , '1' , '1'},
            {'1' , '0' , '0' , '1' , '0'}
        };
        System.out.println(dp.dpFindMaxSquare(square));
    }
}
