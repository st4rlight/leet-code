package cn.st4rlight.solution.array.slid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-17
 */
public class _3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> currMap = new HashMap<>();

        int result = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            // 右侧窗口滑动
            Integer currCnt = currMap.getOrDefault(rightChar, 0);
            currMap.put(rightChar, currCnt + 1);

            // 左侧窗口滑动
            while (currMap.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                Integer leftCnt = currMap.get(leftChar);
                currMap.put(leftChar, leftCnt - 1);
                left++;
            }

            // 结果更新
            result = Math.max(result, right - left);
        }

        return result;
    }
}
