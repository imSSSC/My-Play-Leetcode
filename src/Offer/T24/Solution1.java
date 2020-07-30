package Offer.T24;

// 剑指 Offer 24. 反转链表
//https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

// 时间复杂度：?
// 空间复杂度：?
public class Solution1 {

    public ListNode reverseList(ListNode head) {

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

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
