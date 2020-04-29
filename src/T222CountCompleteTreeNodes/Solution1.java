package T222CountCompleteTreeNodes;

// 222. 完全二叉树的节点个数
// https://leetcode-cn.com/problems/count-complete-tree-nodes/
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

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        if (root.left != null)
            count += countNodes(root.left);
        if (root.right != null)
            count += countNodes(root.right);
        return count;
    }
}
