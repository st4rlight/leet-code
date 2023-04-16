package cn.st4rlight.solution.array.diff;

import java.util.Arrays;

import cn.st4rlight.template.DiffArray;

/**
 * 差分数组题
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _370 {

    int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Arrays.fill(nums, 0);

        DiffArray diffArray = new DiffArray(nums);
        for (int[] update : updates) {
            diffArray.increment(update[0], update[1], update[2]);
        }

        return diffArray.getResult();
    }
}
