package T437PathSumii;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

// 437. 路径总和 III
// https://leetcode-cn.com/problems/path-sum-iii/
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

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = getPathSum(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    public int getPathSum(TreeNode node, int num) {
        if (node == null) return 0;
        int res = 0;
        if (num == node.val) res++;
        res += getPathSum(node.left, num - node.val);
        res += getPathSum(node.right, num - node.val);
        return res;
    }
}
