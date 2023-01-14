package cn.st4rlight.solution.number;

/**
 * 要考虑越界问题
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S2235 {

    public int sum(int num1, int num2) {
        if (num1 == 0 || num2 == 0 || (num1 ^ num2) < 0) {
            // 任一个数为0，或者两者异号，安全，直接相加
            return num1 + num2;
        } else if (num1 < 0 && num1 + num2 >= 0) {
            // 两数<0，加和后大于等于0，溢出
            throw new RuntimeException("精度溢出");
        } else if (num1 > 0 && num1 + num2 < 0) {
            // 两数>0，嘉禾后小于0，溢出
            throw new RuntimeException("精度溢出");
        } else {
            // 安全
            return num1 + num2;
        }
    }
}
