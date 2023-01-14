package cn.st4rlight.solution.number;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reverse = 0;
        int work = x;
        while (work != 0) {
            reverse = reverse * 10 + work % 10;
            work = work / 10;
        }

        return reverse == x;
    }
}
