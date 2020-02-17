package T206ReverseLinkedList;

/**
 * @auther: snake
 * @date: 2020/2/17 17:33
 */

// 206. 反转链表
// https://leetcode-cn.com/problems/reverse-linked-list/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 将下个节点指针,移动一位(获取下个节点指针)
            ListNode next = cur.next;

            // 指针方向改变
            cur.next = pre;

            // 将前节点指针,指向当前节点 移动一位
            pre = cur;
            // 将当前节点指针,指向下个节点 移动一位
            cur = next;
        }

        return pre;
    }


}
