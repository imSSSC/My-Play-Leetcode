package T112PathSum;

// 112. 路径总和
// https://leetcode-cn.com/problems/path-sum/
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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // 没有子节点
        if (root.left == null && root.right == null && root.val == sum) return true;
        // 有子节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
