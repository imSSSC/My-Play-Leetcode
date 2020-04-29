package T257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

// 257. 二叉树的所有路径
// https://leetcode-cn.com/problems/binary-tree-paths/
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (String leftPath : leftPaths) {
            paths.add(root.val + "->" + leftPath);
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (String rightPath : rightPaths) {
            paths.add(root.val + "->" + rightPath);
        }
        return paths;
    }
}
