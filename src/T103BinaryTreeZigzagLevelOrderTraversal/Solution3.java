package T103BinaryTreeZigzagLevelOrderTraversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 103. 二叉树的锯齿形层次遍历
// https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
// 二叉树的层序遍历(宽/广度优先搜索（BFS）)
// 时间复杂度: O(n), n为树的节点个数
// 空间复杂度: O(n)
// 队列 不需要pair组队 也不需要记录层数
public class Solution3 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
    // todo
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//
//        boolean left = true;
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//
//            List<Integer> vales = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node;
//                if (left) {
//                    node = queue.pop();
//                } else {
//                    node = queue.pollLast();
//                }
//                assert node != null;
//                vales.add(node.val);
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            res.add(vales);
//            left = false;
//        }
//        return res;
//    }

}
