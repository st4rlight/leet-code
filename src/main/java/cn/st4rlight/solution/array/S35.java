package cn.st4rlight.solution.array;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S35 {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return left;
        }

        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, left, mid, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
