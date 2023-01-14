package cn.st4rlight.solution.array;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }

        int work = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[work] || nums[i] != nums[work - 1]) {
                nums[++work] = nums[i];
            }
        }
        return work + 1;
    }
}
