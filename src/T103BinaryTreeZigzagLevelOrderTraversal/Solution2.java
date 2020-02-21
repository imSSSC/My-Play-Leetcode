package T103BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

// 103. 二叉树的锯齿形层次遍历
// https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
// 二叉树的层序遍历(递归)
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
public class Solution2 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
// todo
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) {
//            return res;
//        }
//        bfs(root, 0);
//        return res;
//    }
//
//    private void bfs(TreeNode root, Integer level) {
//        if (res.size() == level) res.add(new ArrayList<>());
//        res.get(level).add(root.val);
//        if (root.left != null) bfs(root.left, level + 1);
//        if (root.right != null) bfs(root.right, level + 1);
//    }
}
