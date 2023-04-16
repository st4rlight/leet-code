package cn.st4rlight.solution.array.double_pointer;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int work = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[work] < nums[i]) {
                nums[++work] = nums[i];
            }
        }

        return work + 1;
    }
}
