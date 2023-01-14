package cn.st4rlight.solution.logic;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S277 {

    public int findCelebrity(int n) {
        if (n < 2) {
            return -1;
        }

        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (possible != i && (!knows(i, possible) || knows(possible, i))) {
                return -1;
            }
        }

        return possible;
    }

    /**
     * 官方定义的辅助函数
     */
    private boolean knows(int a, int b) {
        return false;
    }
}
