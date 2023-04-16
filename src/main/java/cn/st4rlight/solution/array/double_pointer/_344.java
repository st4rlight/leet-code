package cn.st4rlight.solution.array.double_pointer;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _344 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
