package T404SumOfLeftLeaves;

// 404. 左叶子之和
// https://leetcode-cn.com/problems/sum-of-left-leaves/
// 二叉树 递归
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            count += root.left.val;
        }
        count += sumOfLeftLeaves(root.left);
        count += sumOfLeftLeaves(root.right);
        return count;
    }

}
