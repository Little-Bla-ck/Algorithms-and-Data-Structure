import java.util.*;

class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        s = s.trim();
        List<String> wordsList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordsList);
        

        return String.join(" ", wordsList);
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        System.out.println(solve.reverseWords("abcd defg"));
    }
}