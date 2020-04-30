package T236LowestCommonAncestorOfABinaryTree;

// 236. 二叉树的最近公共祖先
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
//
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. node是p或者q,返回root
        if (root == null) return null;
        if (root == p || root == q) return root;

        // node不是p,q递归查, 左右孩子,是否含有p,q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 2. left没有,肯定在right
        if (left == null) return right;
        // 3. right没有,肯定在left
        if (right == null) return left;
        // 4. 都包含,说明在node两侧
        return root;
    }
}