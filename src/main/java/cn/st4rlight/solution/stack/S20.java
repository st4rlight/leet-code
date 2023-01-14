package cn.st4rlight.solution.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <p>对于栈的操作，只要是入栈就判断是否满了，只要是出栈就要判断是否为空</p>
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S20 {

    Map<Character, Character> map = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> rightMatch = map.keySet();
        Set<Character> leftMatch = map.entrySet().stream().map(item -> item.getValue()).collect(Collectors.toSet());

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (leftMatch.contains(temp)) {
                stack.push(temp);
            } else if (rightMatch.contains(temp)) {
                if (!stack.isEmpty() && map.get(temp).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
