package cn.st4rlight.solution.array.diff;

import java.util.Arrays;

/**
 * 差分数组变形
 * 这一题的问题在于，乘客在to处下车，因此to处就不能计算为占用座位
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) {
            return true;
        }

        int maxStation = 0;
        for (int[] trip : trips) {
            maxStation = Math.max(maxStation, trip[2]);
        }

        int[] diff = new int[maxStation + 1];
        Arrays.fill(diff, 0);

        for (int[] trip : trips) {
            if (trip[0] > capacity) {
                return false;
            }
            updateDiff(trip, diff);
        }

        int[] usedSeat = new int[diff.length];
        usedSeat[0] = diff[0];
        for (int i = 1; i < usedSeat.length; i++) {
            usedSeat[i] = usedSeat[i - 1] + diff[i];
            if (usedSeat[i] > capacity) {
                return false;
            }
        }

        return true;
    }

    public void updateDiff(int[] booking, int[] diff) {
        int left = booking[1];
        int right = booking[2] - 1;
        int val = booking[0];

        diff[left] += val;
        if (right + 1 < diff.length) {
            diff[right + 1] -= val;
        }
    }
}
