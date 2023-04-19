package cn.st4rlight.solution.array.binary;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-18
 */
public class _34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int leftResult = this.leftBound(nums, target);
        if (leftResult == -1) {
            return new int[]{-1, -1};
        }

        int rightResult = this.rightBound(nums, target);
        return new int[]{leftResult, rightResult};
    }


    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left > nums.length - 1) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left - 1 < 0) {
            return -1;
        }

        return nums[left - 1] == target ? left - 1 : -1;
    }
}
