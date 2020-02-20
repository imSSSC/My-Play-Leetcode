package T234PalindromeLinkedList;


/**
 * @auther: snake
 * @date: 2020/2/19 21:11
 */

// 234. 回文链表
// https://leetcode-cn.com/problems/palindrome-linked-list/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode firstHalfEnd = findMiddleNode(head);

        ListNode secondHalfStart = reverseLinkedList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while (p2 != null) {// 第二段要少于第一段,只要第二段结束.
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {

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

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1};

        System.out.println(new Solution1().isPalindrome(new ListNode(arr)));
    }
}
