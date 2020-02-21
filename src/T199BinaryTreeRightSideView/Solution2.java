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
// 双队列( cur  next)
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

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> cur = new LinkedList<>();// 当前层的队列
        cur.add(root);
        while (!cur.isEmpty()) {
            res.add(cur.peek().val);
            Queue<TreeNode> next = new LinkedList<>();// 下层的队列
            for (TreeNode node : cur) {
                if (node.right != null) next.offer(node.right);
                if (node.left != null) next.offer(node.left);
            }
            cur = next;
        }
        return res;
    }
}
