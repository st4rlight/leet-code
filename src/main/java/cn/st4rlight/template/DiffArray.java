package cn.st4rlight.template;

/**
 * 差分数组
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class DiffArray {

    // 差分数组
    private final int[] diff;
    // 原始数组（当前工具类不会直接修改其值）
    private final int[] nums;


    /**
     * 原始数组转换成差分数组
     */
    public DiffArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException();
        }

        this.diff = new int[nums.length];
        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        this.nums = nums;
    }


    /**
     * 区间增减操
     *
     * @param left 左闭
     * @param right 右闭
     * @param val 可能为负值
     */
    public void increment(int left, int right, int val) {
        if (left > right) {
            return;
        }

        diff[left] += val;
        if (right + 1 < diff.length) {
            diff[right + 1] -= val;
        }
    }


    public int[] getResult() {
        int[] result = new int[diff.length];
        result[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            result[i] = diff[i] + result[i - 1];
        }

        return result;
    }
}
