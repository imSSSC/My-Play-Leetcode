package T150EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * @author snake
 * on 2020/2/20 15:15.
 */
// 150. 逆波兰表达式求值
// https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 栈:找对出栈入栈
public class Solution1 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer first, second;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution1().evalRPN(tokens));
    }
}
