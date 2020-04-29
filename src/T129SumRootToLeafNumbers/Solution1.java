package T129SumRootToLeafNumbers;

import java.util.ArrayList;
import java.util.List;

// 129. 求根到叶子节点数字之和
// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
// 二叉树 递归
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
// 复杂
public class Solution1 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        getNumberList(root, new StringBuilder(), numbers);
        return numbers.stream().mapToInt((x)->x).sum();
    }

    private void getNumberList(TreeNode node, StringBuilder numberString, List<Integer> sumNumbers) {
        if (node == null) return;
        numberString.append(node.val);
        if (node.left == null && node.right == null) {
            sumNumbers.add(Integer.parseInt(numberString.toString()));
        } else {
            getNumberList(node.left, numberString, sumNumbers);
            getNumberList(node.right, numberString, sumNumbers);
        }
        numberString.delete(numberString.length() - 1, numberString.length());
    }
}
