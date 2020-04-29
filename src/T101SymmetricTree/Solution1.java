package T101SymmetricTree;

// 101. 对称二叉树
// https://leetcode-cn.com/problems/symmetric-tree/
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

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode treeNode1, TreeNode treeNode2) {
        // 都为空
        if (treeNode1 == null && treeNode2 == null) return true;
        // 都不为空
        if (treeNode1 != null && treeNode2 != null && treeNode1.val == treeNode2.val)
            return isMirror(treeNode1.left, treeNode2.right) && isMirror(treeNode1.right, treeNode2.left);
        // 有一个为空
        return false;
    }
}
