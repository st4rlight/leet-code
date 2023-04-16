package cn.st4rlight.solution.array.prefix;

/**
 * 前缀数组思想，核心需要保存下区间信息
 * 同时0号位置可以作为一个dummy node用于优化代码
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _303 {

    class NumArray {

        private int[] preSum;

        public NumArray(int[] nums) {
            if (nums == null) {
                return;
            }

            preSum = new int[nums.length + 1];
            preSum[0] = 0;

            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = nums[i - 1] + preSum[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
