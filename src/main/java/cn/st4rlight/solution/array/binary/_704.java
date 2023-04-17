package cn.st4rlight.solution.array.binary;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-18
 */
public class _704 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
