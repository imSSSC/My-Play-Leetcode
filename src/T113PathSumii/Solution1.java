package T113PathSumii;

import java.util.ArrayList;
import java.util.List;

// 113. 路径总和 II
// https://leetcode-cn.com/problems/path-sum-ii/
// 二叉树 递归 dfs + 回溯
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathSum = new ArrayList<>();
        getPath(root, 0, sum, new ArrayList<Integer>(), pathSum);
        return pathSum;
    }

    private void getPath(TreeNode node, int sum, int target, ArrayList<Integer> path, List<List<Integer>> pathSum) {
        if (node == null) return;
        sum += node.val;
        path.add(node.val);
        // 判断该路径和是否符合目标值
        if (sum == target && node.right == null && node.left == null) {
            pathSum.add(new ArrayList<>(path));
        } else {
            getPath(node.left, sum, target, path, pathSum);
            getPath(node.right, sum, target, path, pathSum);
        }
        path.remove(path.size()-1);
    }
}
