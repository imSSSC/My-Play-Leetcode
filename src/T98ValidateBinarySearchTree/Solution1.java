package T98ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

// 98. 验证二叉搜索树
// https://leetcode-cn.com/problems/validate-binary-search-tree/
// 二叉树 递归 dfs
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return dfs(node.left, lower, node.val) && dfs(node.right, node.val, upper);
    }
}
