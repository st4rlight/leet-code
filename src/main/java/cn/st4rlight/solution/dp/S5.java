package cn.st4rlight.solution.dp;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int resultLength = 1;
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (dp[i][i + 1]) {
                resultLength = 2;
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)) {
                    dp[i][i + len - 1] = dp[i + 1][i + len - 2];
                } else {
                    dp[i][i + len - 1] = false;
                }

                if (dp[i][i + len - 1]) {
                    resultLength = Math.max(resultLength, len);
                }
            }
        }

        String result = null;
        for (int i = 0; i <= s.length() - resultLength; i++) {
            if (dp[i][i + resultLength - 1]) {
                result = s.substring(i, i + resultLength);
                break;
            }
        }
        return result;
    }
}
