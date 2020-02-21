package T107BinaryTreeLevelOrderTraversalII;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 107. 二叉树的层次遍历 II
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
// 二叉树的层序遍历(宽/广度优先搜索（BFS）)
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
// 双队列: 每次都放在队列首
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

    // bfs
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();

            if (level == res.size()) {
                res.addFirst(new ArrayList<>());
            }
            res.get(0).add(node.val);
            if (node.left != null) queue.offer(new Pair<>(node.left, level + 1));
            if (node.right != null) queue.offer(new Pair<>(node.right, level + 1));
        }

        return res;
    }
}
