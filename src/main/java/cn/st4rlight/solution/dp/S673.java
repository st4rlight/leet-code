package cn.st4rlight.solution.dp;

/**
 * <p>本题需要注意的地方在于</p>
 * <ol>
 *     <li>该题为变种题目，不仅要记录dp（长度），而且要记录个数</li>
 *     <li>在状态迁移时，要同时迁移记录个数（应该是继承或者累加）</li>
 * </ol>
 * 最长不下降子序列变种
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S673 {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        int[] cnt = new int[nums.length + 1];

        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxLength) {
                result += cnt[i];
            }
        }
        return result;
    }
}
