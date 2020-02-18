package T94BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther: snake
 * @date: 2020/2/18 21:46
 */

// 94. 二叉树的中序遍历
// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/// 非递归二叉树的中序遍历(栈)
// 递归二叉树的中序遍历
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(h), h为树的高度
public class Solution2 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Command {
        private String s;
        private TreeNode node;

        public Command(String s, TreeNode node) {
            this.node = node;
            this.s = s;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print")) {
                res.add(command.node.val);
            } else {
                assert command.s.equals("go");
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }

        return res;
    }

    // todo 常规的
    // todo morris
}
