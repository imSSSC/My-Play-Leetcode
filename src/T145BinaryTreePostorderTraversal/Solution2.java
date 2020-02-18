package T145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther: snake
 * @date: 2020/2/18 21:46
 */

// 145. 二叉树的后序遍历
// https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
// 非递归二叉树的后序遍历(栈)
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

    enum OptionEnum {
        GO, PRINT
    }

    private class Command {
        private OptionEnum option;
        private TreeNode node;

        Command(OptionEnum option, TreeNode node) {
            this.option = option;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command(OptionEnum.GO, root));

        while (!stack.empty()) {
            Command command = stack.pop();
            if (command.option.equals(OptionEnum.PRINT)) {
                res.add(command.node.val);
            } else {
                stack.push(new Command(OptionEnum.PRINT, command.node));
                if (command.node.right != null) {
                    stack.push(new Command(OptionEnum.GO, command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command(OptionEnum.GO, command.node.left));
                }
            }
        }

        return res;
    }

}
