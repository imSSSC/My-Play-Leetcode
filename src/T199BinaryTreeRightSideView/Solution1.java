package T199BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 199. 二叉树的右视图
// https://leetcode-cn.com/problems/binary-tree-right-side-view/
// 二叉树的层序遍历(宽/广度优先搜索（BFS）)
// 时间复杂度: O(n)
// 空间复杂度: O(n)
// 单队列
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> vales = new ArrayList<>(); // 用于存储每层的节点值
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                vales.add(node.val);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            res.add(vales.get(0));// 每次取第一个值.
        }
        return res;
    }
}
