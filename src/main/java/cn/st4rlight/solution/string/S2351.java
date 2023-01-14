package cn.st4rlight.solution.string;

import java.util.Arrays;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S2351 {
    public char repeatedCharacter(String s) {
        boolean[] everShow = new boolean[26];
        Arrays.fill(everShow, false);

        char result = 'a';
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (everShow[item - 'a']) {
                result = item;
                break;
            }
            everShow[item - 'a'] = true;
        }

        return result;
    }
}
