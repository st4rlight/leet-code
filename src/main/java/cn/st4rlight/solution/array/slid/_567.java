package cn.st4rlight.solution.array.slid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }
        if (s2 == null || s2.length() == 0) {
            return false;
        }

        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer currCnt = needMap.getOrDefault(c, 0);
            needMap.put(c, currCnt + 1);
        }

        Map<Character, Integer> currMap = new HashMap<>();
        Queue<Integer> indexQueue = new LinkedList<>();

        int right = 0;
        int match = 0;
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            right++;

            if(needMap.containsKey(rightChar)) {
                Integer currCnt = currMap.getOrDefault(rightChar, 0);
                currMap.put(rightChar, currCnt + 1);
                indexQueue.add(right - 1);
                if (currCnt + 1 == needMap.get(rightChar)) {
                    match++;
                }
            }

            while (match == needMap.size()) {
                Integer left = indexQueue.poll();
                if (right - left == s1.length()) {
                    return true;
                }

                char leftChar = s2.charAt(left);
                Integer currCnt = currMap.get(leftChar);
                currMap.put(leftChar, currCnt - 1);
                if (currCnt.equals(needMap.get(leftChar))) {
                    match--;
                }
            }
        }

        return false;
    }
}
