package cn.st4rlight.solution.array.slid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-17
 */
public class _438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        if (p == null || p.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char tempChar = p.charAt(i);
            Integer cnt = needMap.getOrDefault(tempChar, 0);
            needMap.put(tempChar, cnt + 1);
        }

        Map<Character, Integer> currMap = new HashMap<>();
        int match = 0;
        Queue<Integer> indexQueue = new LinkedList<>();


        List<Integer> resultList = new ArrayList<>();
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
                char leftChar = s.charAt(left);

                if (right - left == p.length()) {
                    resultList.add(left);
                }

                Integer currCnt = currMap.get(leftChar);
                currMap.put(leftChar, currCnt - 1);
                if (currCnt.equals(needMap.get(leftChar))) {
                    match--;
                }
            }
        }

        return resultList;
    }
}
