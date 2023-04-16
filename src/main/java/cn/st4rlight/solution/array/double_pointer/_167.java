package cn.st4rlight.solution.array.double_pointer;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{numbers[left], numbers[right]};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[0];
    }
}
