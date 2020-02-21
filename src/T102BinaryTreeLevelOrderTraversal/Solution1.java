package T102BinaryTreeLevelOrderTraversal;

import javafx.util.Pair;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102. 二叉树的层次遍历
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
// 二叉树的层序遍历(宽/广度优先搜索（BFS）)
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
// 队列 需要pair,需要记录level
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> front = queue.poll();
            TreeNode node = front.getKey();
            Integer level = front.getValue();

            if (res.size() == level) { // 新增的层数第一次和外层List的size是一致的.
                res.add(new ArrayList<>());
            }

            res.get(level).add(node.val);
            if (node.left != null) queue.offer(new Pair<>(node.left, level + 1));
            if (node.right != null) queue.offer(new Pair<>(node.right, level + 1));
        }
        return res;
    }
}
