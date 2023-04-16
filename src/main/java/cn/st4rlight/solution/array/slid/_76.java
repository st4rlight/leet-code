package cn.st4rlight.solution.array.slid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 使用滑动窗口思想实现，以下几个注意点
 * 1. 使用左闭右开区间，这样子好处理好窗口
 * 2. 可以使用match计数来标识左窗口需要移动的时机
 * 3. 使用queue来标识左窗口有效位置，提高速度
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _76 {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer cnt = needMap.getOrDefault(c, 0);
            needMap.put(c, cnt + 1);
        }

        int start = 0;
        int length = Integer.MAX_VALUE;
        Queue<Integer> indexQueue = new LinkedList<>();
        Map<Character, Integer> currMap = new HashMap<>();

        int match = 0;
        int right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            if (needMap.containsKey(rightChar)) {
                Integer currCnt = currMap.getOrDefault(rightChar, 0);
                currMap.put(rightChar, currCnt + 1);
                indexQueue.add(right - 1);
                if (currCnt + 1 == needMap.get(rightChar)) {
                    match++;
                }
            }

            while (match == needMap.size()) {
                Integer left = indexQueue.poll();
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                Integer currCnt = currMap.get(leftChar);
                currMap.put(leftChar, currCnt - 1);
                if (currCnt.equals(needMap.get(leftChar))) {
                    match--;
                }
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
