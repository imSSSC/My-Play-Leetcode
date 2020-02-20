package T71SimplifyPath;

import java.util.Stack;

/**
 * @author snake
 * on 2020/2/20 15:15.
 */
// 71. 简化路径
// https://leetcode-cn.com/problems/simplify-path/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 栈:找对出栈入栈
public class Solution1 {
    public String simplifyPath(String path) {

        // 入栈
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        for (String s : strings) {
            if (s.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (!s.equals("") && !s.equals(".")) stack.push(s);

        }

        // 出栈拼接
        StringBuilder builder = new StringBuilder();
        for (String str : stack)
            builder.append("/").append(str);
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(new Solution1().simplifyPath(path));
    }
}
