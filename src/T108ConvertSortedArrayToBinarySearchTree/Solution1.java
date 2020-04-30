package T108ConvertSortedArrayToBinarySearchTree;

// 108. 将有序数组转换为二叉搜索树
// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
//
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return divide(nums, 0, nums.length - 1);
    }

    private TreeNode divide(int[] nums, int left, int right) {
        if (right < left) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = divide(nums, left, mid - 1);
        node.right = divide(nums, mid + 1, right);
        return node;
    }
}
