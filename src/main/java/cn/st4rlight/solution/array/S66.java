package cn.st4rlight.solution.array;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-14
 */
public class S66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int remain = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + remain;
            digits[i] = sum % 10;
            remain = sum / 10;
        }

        if (remain == 0) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = remain;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}
