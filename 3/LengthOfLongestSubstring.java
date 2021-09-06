import java.util.HashSet;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstringLB(String s) {
        int len = s.length();
        if (len == 1) {
            return len;
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            HashSet<Character> sb = new HashSet<>();
            sb.add(s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                if (sb.contains(s.charAt(j))) {
                    max = Math.max(max, j - i);
                    break;
                }

                if (j == len - 1) {
                    max = Math.max(max, j - i + 1);
                }
                sb.add(s.charAt(j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstringLB("aaaabcd"));
    }
}