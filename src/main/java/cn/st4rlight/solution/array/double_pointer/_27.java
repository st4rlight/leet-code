package cn.st4rlight.solution.array.double_pointer;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int work = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++work] = nums[i];
            }
        }

        return work + 1;
    }
}
