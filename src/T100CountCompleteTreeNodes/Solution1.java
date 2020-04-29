package T100CountCompleteTreeNodes;

// 100. 相同的树
// https://leetcode-cn.com/problems/same-tree/
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p,q都为空 true
        if (p == null && q == null) return true;
        // p,q都不为空 递归判断
        if (p != null && q != null && p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        // p,q有一个为空 false
        return false;
    }
}
