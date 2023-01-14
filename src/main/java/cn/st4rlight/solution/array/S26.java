package cn.st4rlight.solution.array;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S26 {

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
