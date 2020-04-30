package T230KthSmallestElementInAbst;

// 230. 二叉搜索树中第K小的元素
// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
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

    int n = 0;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode node, int k) {
        // 剪枝
        if (node == null || n > k) return;
        inOrder(node.left, k);
        n++;
        if (n == k) res = node.val;
        inOrder(node.right, k);
    }
}
