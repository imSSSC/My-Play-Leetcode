package T111MinimumDepthOfBinaryTree;

// 111. 二叉树的最小深度
// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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

    // 演变思路
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
//
//        // 有为空,为空的深度肯定为0
//        if (leftDepth == 0 || rightDepth == 0) return leftDepth + rightDepth + 1;
//
//        // 都不为空 ,取最小的
//        return Math.min(leftDepth, rightDepth) + 1;
//    }

    // 简化之后
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 1.有为空,为空的深度肯定为0 ,
        // 2.都不为空,递归取最小的
        return leftDepth == 0 || rightDepth == 0 ?  leftDepth + rightDepth + 1: Math.min(leftDepth, rightDepth) + 1;
    }
}
