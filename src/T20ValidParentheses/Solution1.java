package T20ValidParentheses;

import java.util.Stack;

/**
 * @auther: snake
 * @date: 2020/2/18 20:40
 */
// 20. 有效的括号
// https://leetcode-cn.com/problems/valid-parentheses/description/
// 时间复杂度: O(n)
// 空间复杂度: O(n)
// 栈
public class Solution1 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.empty())
                    return false;

                char match;
                if (c == ')') {
                    match = '(';
                } else if (c == '}') {
                    match = '{';
                } else {
                    assert c == ']';
                    match = '[';
                }

                if (!stack.pop().equals(match))
                    return false;
            }
        }
        return stack.empty();
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new Solution1()).isValid("()"));
        printBool((new Solution1()).isValid("()[]{}"));
        printBool((new Solution1()).isValid("(]"));
        printBool((new Solution1()).isValid("([)]"));
    }
}
