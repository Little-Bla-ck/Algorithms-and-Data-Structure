public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size() - 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle.get(i).get(j) += Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j + 1));
            } 
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        minimumTotal.minimumTotal(triangle);
    }
}