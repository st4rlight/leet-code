package cn.st4rlight.solution.dp;

import java.util.Arrays;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
