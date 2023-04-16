package cn.st4rlight.solution.array.diff;

import java.util.Arrays;

/**
 * 差分数组题
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (bookings == null || bookings.length == 0) {
            return new int[0];
        }

        int[] diff = new int[n];
        Arrays.fill(diff, 0);

        for (int[] booking : bookings) {
            updateDiff(booking, diff);
        }

        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

    public void updateDiff(int[] booking, int[] diff) {
        int left = booking[0] - 1;
        int right = booking[1] - 1;
        int val = booking[2];

        diff[left] += val;
        if (right + 1 < diff.length) {
            diff[right + 1] -= val;
        }
    }
}
