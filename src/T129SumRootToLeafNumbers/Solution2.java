package T129SumRootToLeafNumbers;

// 129. 求根到叶子节点数字之和
// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
// 二叉树 递归
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
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

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int i) {
        if (node == null) return 0;
        int temp = i * 10 + node.val;
        if (node.right == null && node.left == null) return temp;
        return helper(node.left, temp) + helper(node.right, temp);
    }

}
