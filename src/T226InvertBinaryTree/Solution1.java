package T226InvertBinaryTree;

// 226. 翻转二叉树
// https://leetcode-cn.com/problems/invert-binary-tree/
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
    }
}
