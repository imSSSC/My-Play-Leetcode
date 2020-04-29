package T110BalancedBinaryTree;

// 110. 平衡二叉树
// https://leetcode-cn.com/problems/balanced-binary-tree/
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getMaxLength(root.left)-getMaxLength(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 计算最大深度
    public int getMaxLength(TreeNode treeNode) {
        return treeNode == null ? 0 : Math.max(getMaxLength(treeNode.left), getMaxLength(treeNode.right))+1;
    }

}
