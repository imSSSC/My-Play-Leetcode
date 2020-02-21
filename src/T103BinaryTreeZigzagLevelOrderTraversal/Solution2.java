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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        bfs(root, 0);
        return res;
    }

    private void bfs(TreeNode node, Integer level) {
        if (res.size() == level) res.add(new ArrayList<>());

        if (level % 2 == 0) res.get(level).add(node.val);
        else res.get(level).add(0, node.val);

        if (node.left != null) bfs(node.left, level + 1);
        if (node.right != null) bfs(node.right, level + 1);
    }
}
