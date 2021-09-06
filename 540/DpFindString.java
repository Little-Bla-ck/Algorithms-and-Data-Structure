public class DpFindString {
    //二维数组法解决；
    public int dpFindStringD2(String str) {
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        //回文字符串的数量；
        //字符串从后往前判断；
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    continue;
                }
                dp[i][j] = (j - i <= 2) || (dp[i+1][j-1]);
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    //一维数组法解决；
    public int dpFindStringD1(String str) {
        int len = str.length();
        boolean[] dp = new boolean[len];
        int count = 0;
        //回文字符串的数量；
        //字符串从后往前判断；
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if ((dp[i] == dp[j]) && (j - i <= 2 || dp[i+1])) {
                    dp[i] = true;
                    count++;
                } else {
                    dp[i] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DpFindString dp = new DpFindString();
        System.out.println(dp.dpFindStringD2("aaaa"));
        System.out.println(dp.dpFindStringD1("aaaa"));
    }
}