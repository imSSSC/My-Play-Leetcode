package T107BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 107. 二叉树的层次遍历 II
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
// 二叉树的层序遍历(宽/广度优先搜索（BFS）)
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
// bfs 翻转
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> vales = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                vales.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(vales);
        }

        Collections.reverse(res);
        return res;
    }
}
