package T143ReorderList;

/**
 * @auther: snake
 * @date: 2020/2/17 23:45
 */

// 143. 重排链表
// https://leetcode-cn.com/problems/reorder-list/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 快慢指针取中心节点+分割链表+翻转链表+连接链表
public class Solution1 {
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        // 快慢指针找中心点, 慢指针为中心点
        // 1->2->3->4->5 选取3位中心节点  1->2->3->4->5->6 取 4位中心点
        ListNode middleNode = getMiddleNode(head);

        // 分割为左右链表
        ListNode left = head; // 原始左链表 1->2->3->4->5
        ListNode right = reverseLinked(middleNode.next);// 中间节点的next为 右节点的head,那么左链表一定大于右链表
        middleNode.next = null;// 将做链表按中心节点分割 1->2->3

        // merge 1->5->2->4->3
        merge(left, right);

    }

    // 获取中心节点
    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {// 注意是 fast 和 fast.next
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // 翻转链表
    private ListNode reverseLinked(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // merge: 1->5->2->4->3  左链表 > 右链表 (结束点 奇数链表 左链表=右链表+1  偶数链表 左链表=右链表+2)
    private void merge(ListNode left, ListNode right) {

        while (right != null) { // 当右链表为空的时候,就结束循环
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        ListNode head = new ListNode(arr);

        new Solution1().reorderList(head);
        System.out.println(head);
    }
}
