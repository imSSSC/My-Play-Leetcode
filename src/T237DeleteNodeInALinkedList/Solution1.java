package T237DeleteNodeInALinkedList;

/**
 * @auther: snake
 * @date: 2020/2/17 22:41
 */

// 237. 删除链表中的节点
// https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
//
// 删除指定链表节点  复制后节点,指向下下个节点
// 时间复杂度: O(1)
// 空间复杂度: O(1)
public class Solution1 {
    public void deleteNode(ListNode node) {

        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node2 = head.findNode(2);
        (new Solution1()).deleteNode(node2);
        System.out.println(head);
    }
}
