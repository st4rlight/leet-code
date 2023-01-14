package cn.st4rlight.solution.array;

/**
 * 思路二分查找，定位到一开始的那个数字
 * 不同的地方在于，在二分查找时找到的位置可能不是第一个位置
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-14
 */
public class S34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = binarySearch(nums, 0, nums.length - 1, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }

        int end = start;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                end = i;
            }
        }

        return new int[]{start, end};
    }


    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }


        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else {
            int tempResult = binarySearch(nums, start, mid - 1, target);
            return tempResult == -1 ? mid : tempResult;
        }
    }
}
