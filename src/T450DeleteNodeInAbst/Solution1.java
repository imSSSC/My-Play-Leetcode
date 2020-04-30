package T450DeleteNodeInAbst;

// 450. 删除二叉搜索树中的节点
// https://leetcode-cn.com/problems/delete-node-in-a-bst/
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 左右子树都不为空,找到最右边最小值
            TreeNode minNode = getMinNode(root.right);
            // 方式一: 用右边最小值(或者左边最大值),替换root位置, 需要删除 最右边的最小值
            // 这种方式可以保持二分搜索的平衡,相对复杂.
            TreeNode successor = new TreeNode(minNode.val);
            successor.left = root.left;
            successor.right = removeMin(root.right);
            // 可以清除root,gc回收
            root.left = root.right = null;
            return successor;

//            --------------------------
            // 方式二: 将root的左边最大值,放到root右边最小的位置 ,这种方式简单,但是不保持bst平衡
//            minNode.left = root.left;
//            return root.right;
        }
    }

    private TreeNode getMinNode(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    // 删除node最小点,返回node
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right=null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
